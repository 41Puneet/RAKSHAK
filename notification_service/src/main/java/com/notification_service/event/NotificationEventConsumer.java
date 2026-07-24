package com.notification_service.event;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.notification_service.DTO.Request.SendNotificationRequestDTO;
import com.notification_service.Enums.*;
import com.notification_service.Service.NotificationService;
import com.notification_service.event.Events.EmergencyCreatedEvent;
import com.notification_service.event.Events.HospitalAssignedEvent;
import com.notification_service.event.RabbitMqConstant.RabbitMQConstants;

@Component
public class NotificationEventConsumer {
    private final NotificationService service;
    public NotificationEventConsumer(NotificationService service){this.service=service;}
    @RabbitListener(queues=RabbitMQConstants.NOTIFICATION_EMERGENCY_CREATED_QUEUE)
    public void emergencyCreated(EmergencyCreatedEvent event){
        if(event.getUserId()==null||event.getEmergencyId()==null) throw new IllegalArgumentException("Invalid emergency event");
        service.create(new SendNotificationRequestDTO(event.getUserId(),ReceiverType.USER,"Emergency received","Your emergency request has been received.",NotificationType.EMERGENCY_CREATED,DeliveryChannel.PUSH,event.getEmergencyId()));
    }
    @RabbitListener(queues=RabbitMQConstants.NOTIFICATION_HOSPITAL_ASSIGNED_QUEUE)
    public void hospitalAssigned(HospitalAssignedEvent event){
        if(event.getResponderId()==null||event.getEmergencyId()==null) throw new IllegalArgumentException("Invalid hospital event");
        service.create(new SendNotificationRequestDTO(event.getResponderId(),ReceiverType.RESPONDER,"Hospital assigned","A hospital has been selected for the emergency.",NotificationType.HOSPITAL_ASSIGNED,DeliveryChannel.PUSH,event.getEmergencyId()));
    }
}
