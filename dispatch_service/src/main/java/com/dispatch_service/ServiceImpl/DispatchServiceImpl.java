package com.dispatch_service.ServiceImpl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dispatch_service.Entity.DispatchAssignment;
import com.dispatch_service.Entity.DispatchLog;
import com.dispatch_service.Entity.ResponderLocation;
import com.dispatch_service.Enums.AssignmentStatus;
import com.dispatch_service.Repository.DispatchAssignmentRepository;
import com.dispatch_service.Repository.DispatchLogRepository;
import com.dispatch_service.Repository.ResponderLocationRepository;
import com.dispatch_service.Service.DispatchService;
import com.dispatch_service.Service.GeoService;
import com.dispatch_service.Service.ResponderSelectionService;
import com.dispatch_service.event.model.EmergencyCreatedEvent;
import com.dispatch_service.event.model.ResponderAssignedEvent;
import com.dispatch_service.event.producer.DispatchEventProducer;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DispatchServiceImpl implements DispatchService {

    private final ResponderSelectionService responderSelectionService;
    private final GeoService geoService;
    private final DispatchEventProducer dispatchEventProducer;
    private final DispatchAssignmentRepository dispatchAssignmentRepository;
    private final DispatchLogRepository dispatchLogRepository;
    private final ResponderLocationRepository responderLocationRepository;

    public DispatchServiceImpl(
            ResponderSelectionService responderSelectionService,
            GeoService geoService,
            DispatchEventProducer dispatchEventProducer,
            DispatchAssignmentRepository dispatchAssignmentRepository,
            ResponderLocationRepository responderLocationRepository,
            DispatchLogRepository dispatchLogRepository) {

        this.responderSelectionService = responderSelectionService;
        this.geoService = geoService;
        this.dispatchEventProducer = dispatchEventProducer;
        this.dispatchAssignmentRepository = dispatchAssignmentRepository;
        this.responderLocationRepository = responderLocationRepository;
        this.dispatchLogRepository = dispatchLogRepository;
    }

    @Override
    public void dispatchEmergency(EmergencyCreatedEvent event) {

        if (event == null
                || event.getLatitude() == null
                || event.getLongitude() == null) {
            throw new IllegalArgumentException("Invalid emergency event");
        }

        ResponderLocation responder =
                responderSelectionService.findNearestAvailableResponder(
                        event.getLatitude(),
                        event.getLongitude()); 

        if (responder == null) {
            saveDispatchLog(event.getEmergencyId(),
                    "No responder available right now");
            return;
        }

        double distance = geoService.calculateDistance(
                event.getLatitude(),
                event.getLongitude(),
                responder.getLatitude(),
                responder.getLongitude());

        DispatchAssignment assignment = toDispatchAssignment(event);

        assignment.setResponderId(responder.getResponderId());
        assignment.setDistanceKm(distance);
        assignment.setStatus(AssignmentStatus.ASSIGNED);
        assignment.setAssignedAt(LocalDateTime.now());

        dispatchAssignmentRepository.save(assignment);
        

        responderLocationRepository.updateAvailability(
                responder.getResponderId(),
                false);

        saveDispatchLog(
                event.getEmergencyId(),
                "Responder assigned successfully");

        ResponderAssignedEvent assignedEvent =
                toResponderAssignedEvent(assignment);

        dispatchEventProducer.publishResponderAssigned(assignedEvent);
      
    }

    private void saveDispatchLog(UUID emergencyId, String message) {

        DispatchLog log = new DispatchLog();

        log.setEmergencyId(emergencyId);
        log.setMessage(message);
        log.setTimestamp(LocalDateTime.now());

        dispatchLogRepository.save(log);
    }

    private DispatchAssignment toDispatchAssignment(EmergencyCreatedEvent event) {

        DispatchAssignment assignment = new DispatchAssignment();

        assignment.setEmergencyId(event.getEmergencyId());
        assignment.setPriority(event.getPriority());

        return assignment;
    }

    private ResponderAssignedEvent toResponderAssignedEvent(
            DispatchAssignment assignment) {

        ResponderAssignedEvent event = new ResponderAssignedEvent();

        event.setEmergencyId(assignment.getEmergencyId());
        event.setResponderId(assignment.getResponderId());

        if (assignment.getDistanceKm() != null) {
            event.setDistanceKm(assignment.getDistanceKm());
        }

        event.setStatus(assignment.getStatus());
        event.setAssignedAt(assignment.getAssignedAt());

        return event;
    }
}