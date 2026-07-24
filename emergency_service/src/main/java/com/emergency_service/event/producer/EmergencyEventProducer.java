package com.emergency_service.event.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.emergency_service.event.constant.RabbitMQconstant;
import com.emergency_service.event.model.EmergencyCreatedEvent;
import java.util.UUID;

@Component
public class EmergencyEventProducer{


    private final RabbitTemplate rabbitTemplate;
    

    public EmergencyEventProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
       
    }

    public void publishEmergencyCreated(EmergencyCreatedEvent event){
   rabbitTemplate.convertAndSend(RabbitMQconstant.EMERGENCY_EXCHANGE, RabbitMQconstant.EMERGENCY_CREATED_ROUTING_KEY, event,
           message -> { message.getMessageProperties().setCorrelationId(UUID.randomUUID().toString()); return message; });
    }
}
