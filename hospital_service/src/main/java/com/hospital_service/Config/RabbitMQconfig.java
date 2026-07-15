package com.hospital_service.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hospital_service.Event.RabbitMqConstant.RabbitMQconstant;

@Component
public class RabbitMQconfig {
    

    @Bean
    public TopicExchange EmergencyExchange(){
        return new TopicExchange(RabbitMQconstant.EMERGENCY_EXCHANGE);
    }

    @Bean
    public Queue HospitalAssignedQueue(){
        return QueueBuilder.durable(RabbitMQconstant.HOSPITAL_ASSIGNED_QUEUE).build();
    }

    @Bean
    public Binding HospitalAssignedBinding(Queue HospitalAssignedQueue,TopicExchange EmergencyExchange){
        return BindingBuilder.bind(HospitalAssignedQueue)
                             .to(EmergencyExchange)
                             .with(RabbitMQconstant.HOSPITAL_ASSIGNED_ROUTING_KEY);
    }

    @Bean
    public Queue emergencyPriorityUpdatedQueue(){
        return QueueBuilder.durable(RabbitMQconstant.RESPONDER_ASSIGNED_QUEUE).build();
    }

    @Bean
    public Binding emergencyPriorityUpdateBinding(TopicExchange emergencyExchange,Queue emergencyPriorityUpdateQueue){
       return BindingBuilder.bind(emergencyPriorityUpdateQueue)
                            .to(emergencyExchange)
                            .with(RabbitMQconstant.EMERGENCY_PRIORITY_UPDATED_ROUTING_KEY);

    }
}
