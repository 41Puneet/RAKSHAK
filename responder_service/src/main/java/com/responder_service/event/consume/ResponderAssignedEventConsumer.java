package com.responder_service.event.consume;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.responder_service.Repository.ResponderAssignmentRepository;
import com.responder_service.event.constant.RabbitMQconstant;
import com.responder_service.event.model.ResponderAssignedEvent;


@Component
public class ResponderAssignedEventConsumer {
    
   private final ResponderAssignmentRepository repository;

    public ResponderAssignedEventConsumer(ResponderAssignmentRepository repository){
       this.repository=repository;
    }
    @RabbitListener(queues=RabbitMQconstant.RESPONDER_ASSIGNED_QUEUE)
public void responderAssignedEventConsumer(ResponderAssignedEvent event){

    repository.findByResponderId(event.getResponderId()).ifPresent(responder->{
        responder.setAssignedAt(event.getAssignedAt());
        
    });
}

}
