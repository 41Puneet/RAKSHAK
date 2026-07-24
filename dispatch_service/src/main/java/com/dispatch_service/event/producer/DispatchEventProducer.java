package com.dispatch_service.event.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.dispatch_service.event.Constant.RabbitMqConstant;
import com.dispatch_service.event.model.ResponderAssignedEvent;
import java.util.UUID;

@Component
public class DispatchEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public DispatchEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishResponderAssigned(ResponderAssignedEvent event) {

        rabbitTemplate.convertAndSend(
                RabbitMqConstant.EMERGENCY_EXCHANGE,
                RabbitMqConstant.RESPONDER_ASSIGNED_ROUTING_KEY,
                event,
                message -> { message.getMessageProperties().setCorrelationId(UUID.randomUUID().toString()); return message; }
        );
    }
}
