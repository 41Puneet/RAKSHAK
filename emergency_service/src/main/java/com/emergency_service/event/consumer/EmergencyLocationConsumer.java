package com.emergency_service.event.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.emergency_service.Enums.EntityType;
import com.emergency_service.Repository.EmergencyRepository;
import com.emergency_service.event.constant.RabbitMQconstant;
import com.emergency_service.event.model.LocationUpdatedEvent;

@Component
public class EmergencyLocationConsumer {
    
    private final EmergencyRepository repository;
    public EmergencyLocationConsumer(EmergencyRepository repository){
        this.repository=repository;
    }
    @RabbitListener(queues=RabbitMQconstant.LOCATION_UPDATE_QUEUE)
    public void locationEventConsumer(LocationUpdatedEvent event){

        if(event.getEntityType()!=EntityType.USER){
                return;
            }
        
        repository.findActiveEmergency(event.getEntityId()).ifPresent(emergency->{
            
            emergency.setLatitude(event.getLatitude());
            emergency.setLongitude(event.getLongitude());
            repository.save(emergency);
        }
        );
    }


}
