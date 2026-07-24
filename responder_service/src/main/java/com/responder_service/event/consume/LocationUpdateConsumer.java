package com.responder_service.event.consume;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

import com.responder_service.Entity.Responder;
import com.responder_service.Enums.EntityType;
import com.responder_service.Repository.ResponderRepository;
import com.responder_service.event.constant.RabbitMQconstant;
import com.responder_service.event.model.LocationUpdatedEvent;

@Component
public class LocationUpdateConsumer {
    
    private final ResponderRepository repository;

    public LocationUpdateConsumer(ResponderRepository repository){
        this.repository=repository;
    }

    @RabbitListener(queues=RabbitMQconstant.LOCATION_UPDATE_QUEUE)
    @CacheEvict(cacheNames = {"responderById", "latestResponderLocation"}, key = "#event.entityId")
    public void locationUpdateConsumer(LocationUpdatedEvent event){
       if(event.getEntityType()!=EntityType.RESPONDER){
        return;
       }
       Responder responder=repository.findByResponderId(event.getEntityId());
       if (responder == null) {
        return;
       }
       responder.setLatitude(event.getLatitude());
       responder.setLongitude(event.getLongitude());
       repository.save(responder);
    }
}
