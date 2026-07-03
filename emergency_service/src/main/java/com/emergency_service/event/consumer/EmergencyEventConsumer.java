package com.emergency_service.event.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.emergency_service.Entity.EmergencyRequest;
import com.emergency_service.Entity.ResponderAssignment;
import com.emergency_service.Enums.Status;
import com.emergency_service.Repository.EmergencyRepository;
import com.emergency_service.Repository.ResponderAssignmentRepository;
import com.emergency_service.event.constant.RabbitMQconstant;
import com.emergency_service.event.model.ResponderAssignedEvent;

@Component
public class EmergencyEventConsumer {

    private final EmergencyRepository emergencyRepository;
    private final ResponderAssignmentRepository responderAssignmentRepository;

    public EmergencyEventConsumer(
            EmergencyRepository emergencyRepository,
            ResponderAssignmentRepository responderAssignmentRepository) {

        this.emergencyRepository = emergencyRepository;
        this.responderAssignmentRepository = responderAssignmentRepository;
    }

    @RabbitListener(queues = RabbitMQconstant.RESPONDER_ASSIGNED_QUEUE)
    public void receiveResponderAssigned(ResponderAssignedEvent event) {

        emergencyRepository.findById(event.getEmergencyId()).ifPresent(emergency -> {
            emergency.setResponderId(event.getResponderId());
            emergency.setStatus(Status.ASSIGNED);
            emergency.setUpdatedAt(event.getAssignedAt());
            emergency.setActive(true);

            emergencyRepository.save(emergency);

            ResponderAssignment assignment = new ResponderAssignment();
            assignment.setEmergencyRequest(emergency);
            assignment.setResponderId(event.getResponderId());
            assignment.setAssignedAt(event.getAssignedAt());
            assignment.setStatus(event.getStatus());
            responderAssignmentRepository.save(assignment);
        });
    }
}