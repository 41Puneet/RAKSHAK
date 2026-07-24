package com.tracking_service.RabbitMQevent.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.tracking_service.DTO.Request.LocationUpdateRequest;
import com.tracking_service.RabbitMQevent.Constant.RabbitMQConstants;
import com.tracking_service.RabbitMQevent.event.LocationUpdatedEvent;
import java.util.UUID;

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
                event,
                message -> { message.getMessageProperties().setCorrelationId(UUID.randomUUID().toString()); return message; }
        );
    }

    public void publishLocationUpdatedEvent(LocationUpdateRequest request) {
        publishLocationUpdatedEvent(new LocationUpdatedEvent(request.getEntityId(), request.getEntityType(), request.getLatitude(), request.getLongitude(), request.getTimestamp()));
    }
}
