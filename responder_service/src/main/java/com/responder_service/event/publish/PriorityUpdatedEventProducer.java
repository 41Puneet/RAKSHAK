package com.responder_service.event.publish;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.responder_service.event.constant.RabbitMQconstant;
import com.responder_service.event.model.EmergencyPriorityUpdatedEvent;

@Component
public class PriorityUpdatedEventProducer {
    

    private final RabbitTemplate rabbitTemplate;
    public PriorityUpdatedEventProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }

    public void publishPriorityUpdatedEvent(EmergencyPriorityUpdatedEvent event){
        rabbitTemplate.convertAndSend(RabbitMQconstant.EMERGENCY_EXCHANGE,RabbitMQconstant.EMERGENCY_PRIORITY_UPDATED_ROUTING_KEY,event);
    }
}
