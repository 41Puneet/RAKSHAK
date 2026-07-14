package com.responder_service.ServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.responder_service.DTO.request.AssignResponderRequest;
import com.responder_service.DTO.request.CompleteAssignmentRequest;
import com.responder_service.DTO.request.CreateResponderRequest;
import com.responder_service.DTO.request.RegisterVehicleRequest;
import com.responder_service.DTO.request.UpdateAvailabilityRequest;
import com.responder_service.DTO.request.UpdatePriorityStatus;
import com.responder_service.DTO.request.UpdateResponder;
import com.responder_service.DTO.request.UpdateVehicleRequest;
import com.responder_service.DTO.response.AssignmentResponse;
import com.responder_service.DTO.response.AvailabilityHistoryResponse;
import com.responder_service.DTO.response.LocationHistoryResponse;
import com.responder_service.DTO.response.PriorityResponse;
import com.responder_service.DTO.response.ResponderResponse;
import com.responder_service.DTO.response.VehicleResponse;
import com.responder_service.Entity.ResponderAssignment;
import com.responder_service.Entity.ResponderAvailabilityHistory;
import com.responder_service.Entity.ResponderLocationHistory;
import com.responder_service.Enums.Assignment_Status;
import com.responder_service.Enums.AvailabilityStatus;
import com.responder_service.Enums.DutyStatus;
import com.responder_service.Mapper.ResponderMapper;
import com.responder_service.Repository.ResponderAssignmentRepository;
import com.responder_service.Repository.ResponderAvailabilityRepository;
import com.responder_service.Repository.ResponderLocationHistoryRepository;
import com.responder_service.Repository.ResponderRepository;
import com.responder_service.Repository.ResponderVehicleRepository;
import com.responder_service.event.model.EmergencyPriorityUpdatedEvent;
import com.responder_service.event.publish.PriorityUpdatedEventProducer;
import com.responder_service.Entity.ResponderVehicle;
import com.responder_service.Entity.Responder;
import com.responder_service.service.ResponderService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResponderServiceImpl implements ResponderService {

private final ResponderAssignmentRepository assignmentRepository;
private final ResponderAvailabilityRepository availabilityRepository;
private final ResponderLocationHistoryRepository locationRepository;
private final ResponderRepository responderRepository;
private final ResponderVehicleRepository vehicleRepository;
private final ResponderMapper mapper;
private static final Logger logger=LoggerFactory.getLogger(ResponderServiceImpl.class);
private final PriorityUpdatedEventProducer producer;
public ResponderServiceImpl(ResponderAssignmentRepository assignmentRepository, ResponderAvailabilityRepository availabilityRepository, ResponderLocationHistoryRepository locationRepository, ResponderRepository responderRepository, ResponderVehicleRepository vehicleRepository, ResponderMapper mapper,PriorityUpdatedEventProducer producer) {
    this.assignmentRepository = assignmentRepository;
    this.availabilityRepository = availabilityRepository;
    this.locationRepository = locationRepository;
    this.responderRepository = responderRepository;
    this.vehicleRepository = vehicleRepository;
    this.mapper = mapper;
    this.producer=producer;
}
    @Override
    public AssignmentResponse assignResponder(AssignResponderRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssignmentResponse completeAssignment(CompleteAssignmentRequest request) {
        Optional<ResponderAssignment> assignment = assignmentRepository.findById(request.getId());
        if (assignment.isPresent()) {
            ResponderAssignment responderAssignment = assignment.get();
            responderAssignment.setStatus(Assignment_Status.COMPLETED);
            ResponderAssignment updatedAssignment = assignmentRepository.save(responderAssignment);
            return mapper.toAssignmentResponse(updatedAssignment);
        }
        throw new IllegalArgumentException("Assignment not found with this id"+request.getId());
    }

    @Override
    public ResponderResponse createResponder(CreateResponderRequest request) {
       Optional<Responder> responder1 = responderRepository.findByUserId(request.getUserId());
       if (responder1.isPresent()) {
           throw new IllegalArgumentException("Responder already present with this user Id" + request.getUserId());
       }
       Responder responder = mapper.toResponderEntity(request);
       responder.setId(UUID.randomUUID());
       responder.setStatus(AvailabilityStatus.AVAILABLE);
       responder.setDutyStatus(DutyStatus.OFF_DUTY);
       responder.setLatitude(null);
       responder.setLongitude(null);
       responder.setActive(false);
       responder.setLocation(null);
       responder.setHistory(null);
       responder.setAssignments(null);
       responder.setResponderVehicle(null);
       Responder savedResponder = responderRepository.save(responder);
       return mapper.toResponderResponse(savedResponder);
    }

    @Override
    public void deleteResponder(UUID responderId) {
        Optional<Responder> responder = responderRepository.findById(responderId);
       if(responder.isPresent()){
        responderRepository.delete(responder.get());
       }
       else{
        throw new IllegalArgumentException("Responder not found with this responderId"+responderId);
       }
    }

    @Override
    public void deleteVehicle(UUID vehicleId) {
       Optional<ResponderVehicle>vehicle=vehicleRepository.findById(vehicleId);
       if(vehicle.isPresent()){
        vehicleRepository.delete(vehicle.get());
       }
    else{
        throw new IllegalArgumentException("Vehicle not found with this vehicle Id"+vehicleId);
    }
    }

    @Override
    public AssignmentResponse getAssignmentById(UUID assignmentId) {
       Optional<ResponderAssignment> assignment=assignmentRepository.findById(assignmentId);
       if(assignment.isPresent()){
        return mapper.toAssignmentResponse(assignment.get());
       }
        throw new IllegalArgumentException("Assignment not found with id"+assignmentId);
    }

    @Override
    public Page<AssignmentResponse> getAssignmentResponseByResponderId(UUID responderId, Pageable pageable) {
        Page<ResponderAssignment> assignment = assignmentRepository.findByResponder_Id(responderId, pageable);
        return assignment.map(mapper::toAssignmentResponse);
    }

    @Override
    public Page<AvailabilityHistoryResponse> getAvailabilityByResponderId(UUID responderId, Pageable pageable) {
       Page<ResponderAvailabilityHistory> availability=availabilityRepository.findByResponder_Id(responderId, pageable);
       return availability.map(mapper::toAvailabilityResponse);
    }

    @Override
    public Page<VehicleResponse> getByActiveVehicle(boolean active, Pageable pageable) {
       Page<ResponderVehicle>vehicle=vehicleRepository.findByActive(true, pageable);
       return vehicle.map(mapper::toVehicleResponse);
    }

    @Override
    public Page<AssignmentResponse> getByAssignmentStatus(UUID responderId,Assignment_Status status, Pageable pageable) {
        Page<ResponderAssignment>assignment=assignmentRepository.findByResponder_IdAndStatus(responderId, status, pageable);
        return assignment.map(mapper::toAssignmentResponse);
    }

    @Override
    public LocationHistoryResponse getByResponderIdAndTime(UUID responderId) {
        Optional<ResponderLocationHistory>location=locationRepository.findTopByResponder_IdOrderByTimestampDesc(responderId);
        return mapper.toResponderLocationResponse(location.get());
    }

    @Override
    public Page<LocationHistoryResponse> getByTimeBetween(LocalDateTime start, LocalDateTime end, Pageable pageable) {
      Page<ResponderLocationHistory>location=locationRepository.findByTimestampBetween(start, end, pageable);
      return location.map(mapper::toResponderLocationResponse);
    }

    @Override
    public Page<LocationHistoryResponse> getLocationByResponderId(UUID responderId, Pageable pageable) {
        Page<ResponderLocationHistory>location=locationRepository.findByResponder_Id(responderId, pageable);
        return location.map(mapper::toResponderLocationResponse);
    }

    @Override
    public ResponderResponse getResponderByID(UUID responderId) {
       Responder responder=responderRepository.findByResponderId(responderId);
       if(responder!=null){
        return mapper.toResponderResponse(responder);
       }
        throw new IllegalArgumentException("Responder not found with this id"+responderId);
    }

    @Override
    public VehicleResponse getVehicleByID(UUID vehicleId) {
        Optional<ResponderVehicle>vehicle=vehicleRepository.findById(vehicleId);
        if(vehicle.isPresent()){
            return mapper.toVehicleResponse(vehicle.get());
        }
        throw new IllegalArgumentException("Vehicle not found with this vehicleId"+vehicleId);
    }

    @Override
    public VehicleResponse getVehicleByResponder(UUID responderId) {
        Optional<ResponderVehicle> vehicle=vehicleRepository.findByResponder_Id(responderId);
        if(vehicle.isPresent()){
        return mapper.toVehicleResponse(vehicle.get());
        }
        throw new IllegalArgumentException("Vehicle not found with this responder Id"+responderId);
    }

    @Override
    public VehicleResponse registerVehicle(RegisterVehicleRequest request) {
        Optional<ResponderVehicle>vehicle=vehicleRepository.findByVehicleNumber(request.getVehicleNumber());
        if(vehicle.isPresent()){
            throw new IllegalArgumentException("Vehicle already present with this vehicle Number"+request.getVehicleNumber());
        }
        ResponderVehicle responderVehicle = mapper.toEntity(request);
        responderVehicle.setId(UUID.randomUUID());
        responderVehicle.setActive(false);
        ResponderVehicle saved = vehicleRepository.save(responderVehicle);
        return mapper.toVehicleResponse(saved);
    }

    @Override
    public AvailabilityHistoryResponse updateAvailability(UpdateAvailabilityRequest request, UUID responderId) {
        Optional<ResponderAvailabilityHistory> availability = availabilityRepository.findTopByResponder_IdOrderByChangedAtDesc(responderId);
        if (availability.isPresent()) {
            ResponderAvailabilityHistory availabilityHistory = availability.get();
            if (availabilityHistory.getPreviousStatus() == request.getNewStatus()) {
                throw new RuntimeException("Status is not changed" + request.getNewStatus());
            }
            availabilityHistory.setNewStatus(request.getNewStatus());
            ResponderAvailabilityHistory updatedAvailability = availabilityRepository.save(availabilityHistory);
            return mapper.toAvailabilityResponse(updatedAvailability);
        }
        throw new IllegalArgumentException("Responder availability history not found for responderId " + responderId);
    }

    @Override
    public ResponderResponse updateResponder(UUID responderId, UpdateResponder request) {
       Responder responder=responderRepository.findByResponderId(responderId);
       if(responder!=null){
        responder.setBadgeNumber(request.getBadgeNumber());
        responder.setResponderVehicle(request.getResponderVehicle());
        Responder updateResponder=responderRepository.save(responder);
        return mapper.toResponderResponse(updateResponder);
       }
        throw new IllegalArgumentException("responder not found with this id"+responderId);
    }

    @Override
    public VehicleResponse updateVehicle(UUID vehicleId, UpdateVehicleRequest request) {
        Optional<ResponderVehicle> vehicle=vehicleRepository.findById(vehicleId);
        if(vehicle.isEmpty()){
            throw new IllegalArgumentException("Vehicle not found with this vehicleId"+vehicleId);
        }
        ResponderVehicle responderVehicle = vehicle.get();
        responderVehicle.setVehicleType(request.getVehicleType());
        responderVehicle.setVehicleNumber(request.getVehicleNumber());
        responderVehicle.setModel(request.getModel());
        responderVehicle.setCapacity(request.getCapacity());
        responderVehicle.setActive(request.isActive());
        ResponderVehicle updatedVehicle = vehicleRepository.save(responderVehicle);
        return mapper.toVehicleResponse(updatedVehicle);
    }
    @Override
    public AssignmentResponse updatePriorityofEmergency(UUID emegencyId, UUID responderId,Assignment_Status status,UpdatePriorityStatus request) {
        Optional<ResponderAssignment> assignment=assignmentRepository.findByEmergencyIdAndStatus(emegencyId, responderId, Assignment_Status.ARRIVED);
        if(assignment.isPresent()){
            ResponderAssignment updateAssignment=assignment.get();
           updateAssignment.setPriority(request.getPriority());
           ResponderAssignment savedAssignment=assignmentRepository.save(updateAssignment);
           EmergencyPriorityUpdatedEvent event=toEmergencyPriorityUpdatedEvent(savedAssignment);
           producer.publishPriorityUpdatedEvent(event);
           return mapper.toAssignmentResponse(savedAssignment);
        }
        throw new IllegalArgumentException("Assignment not found");
    }
    
    private EmergencyPriorityUpdatedEvent toEmergencyPriorityUpdatedEvent(ResponderAssignment assignment) {
        EmergencyPriorityUpdatedEvent event = new EmergencyPriorityUpdatedEvent();
        event.setEmergencyId(assignment.getEmergencyId());
        event.setResponderId(assignment.getResponderId());
        event.setPriority(assignment.getPriority());
        event.setTimestamp(LocalDateTime.now());
        return event;
    }
    
}
