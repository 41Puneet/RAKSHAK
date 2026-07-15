package com.hospital_service.Event.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.hospital_service.Event.RabbitMqConstant.RabbitMQconstant;
import com.hospital_service.Event.event.EmergencyPriorityUpdatedEvent;
import com.hospital_service.Service.HospitalService;

@Component
public class EmergencyPriorityUpdateConsumer {
    

    private final HospitalService service;

    public EmergencyPriorityUpdateConsumer(HospitalService service){
        this.service=service;
    }

    @RabbitListener(queues=RabbitMQconstant.EMERGENCY_PRIORITY_UPDATED_QUEUE)
    public void priorityUpdateConsumer(EmergencyPriorityUpdatedEvent event){

        service.findNearestHospital(event);
    }
}
