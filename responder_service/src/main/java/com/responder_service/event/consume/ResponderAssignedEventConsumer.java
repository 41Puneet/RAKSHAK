package com.responder_service.event.consume;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.responder_service.event.constant.RabbitMQconstant;
import com.responder_service.event.model.ResponderAssignedEvent;
import com.responder_service.service.ResponderService;


@Component
public class ResponderAssignedEventConsumer {
    
   private final ResponderService service;

    public ResponderAssignedEventConsumer(ResponderService service){
       this.service=service;
    }
    @RabbitListener(queues=RabbitMQconstant.RESPONDER_ASSIGNED_QUEUE)
public void responderAssignedEventConsumer(ResponderAssignedEvent event){
service.assignResponder(event);
}

}
