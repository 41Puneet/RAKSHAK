package com.tracking_service.RabbitMQevent.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.tracking_service.DTO.Request.LocationUpdateRequest;
import com.tracking_service.RabbitMQevent.Constant.RabbitMQConstants;
import com.tracking_service.RabbitMQevent.event.LocationUpdatedEvent;

@Component
public class LocationEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public LocationEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishLocationUpdatedEvent(LocationUpdatedEvent event) {

        rabbitTemplate.convertAndSend(
                RabbitMQConstants.EMERGENCY_EXCHANGE,
                RabbitMQConstants.LOCATION_UPDATED_ROUTING_KEY,
                event
        );
    }

    public void publishLocationUpdatedEvent(LocationUpdateRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'publishLocationUpdatedEvent'");
    }
}