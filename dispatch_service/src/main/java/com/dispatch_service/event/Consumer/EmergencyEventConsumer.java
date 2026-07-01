package com.dispatch_service.event.Consumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.dispatch_service.event.Constant.RabbitMqConstant;
import com.dispatch_service.Service.DispatchService;
import com.dispatch_service.event.model.EmergencyCreatedEvent;


@Component
public class EmergencyEventConsumer {
    private final DispatchService dispatchService;

    public EmergencyEventConsumer(DispatchService dispatchService) {
        this.dispatchService = dispatchService;
    }
@RabbitListener(queues=RabbitMqConstant.EMERGENCY_CREATED_QUEUE)
    public void handleEmergency(EmergencyCreatedEvent event) {
        dispatchService.dispatchEmergency(event);
    }
}
