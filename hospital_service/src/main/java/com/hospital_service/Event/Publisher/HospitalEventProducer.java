package com.hospital_service.Event.Publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.hospital_service.Event.RabbitMqConstant.RabbitMQconstant;
import com.hospital_service.Event.event.HospitalSelectionEvent;

@Component
public class HospitalEventProducer {
    

    private final RabbitTemplate rabbitTemplate;

    public HospitalEventProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    public void publishHospitalEvent(HospitalSelectionEvent event){
        rabbitTemplate.convertAndSend(RabbitMQconstant.EMERGENCY_EXCHANGE, RabbitMQconstant.HOSPITAL_ASSIGNED_ROUTING_KEY, event);
    }

}
