package com.emergency_service.event.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmergencyEventProducer{


    private final RabbitTemplate rabbitTemplate;

    public EmergencyEventProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    public void publishEmergencyCreated(Object event){

    }
}