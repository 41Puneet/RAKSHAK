package com.dispatch_service.event.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.dispatch_service.Enums.EntityType;
import com.dispatch_service.Repository.ResponderLocationRepository;
import com.dispatch_service.event.Constant.RabbitMqConstant;
import com.dispatch_service.event.model.LocationUpdatedEvent;

import jakarta.transaction.Transactional;

@Component
@Transactional
public class LocationUpdateConsumer {
    

    private final ResponderLocationRepository repository;

    public LocationUpdateConsumer(ResponderLocationRepository repository){
        this.repository=repository;
    }

    @RabbitListener(queues = RabbitMqConstant.LOCATION_UPDATE_QUEUE)
    public void locationUpdateConsumer(LocationUpdatedEvent event){

    if(event.getEntityType()!=EntityType.RESPONDER){
        return;
    }
    repository.findByResponderId(event.getEntityId()).ifPresent(responder->{
        responder.setLatitude(event.getLatitude());
        responder.setLongitude(event.getLongitude());
        responder.setLastUpdated(event.getTimestamp());
        repository.save(responder);
    });
    }
}
