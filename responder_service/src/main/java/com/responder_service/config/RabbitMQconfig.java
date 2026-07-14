package com.responder_service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.responder_service.event.constant.RabbitMQconstant;

@Configuration
public class RabbitMQconfig {
    
    private final TopicExchange EmergencyPriorityUpdatedEvent;

    RabbitMQconfig(TopicExchange EmergencyPriorityUpdatedEvent) {
        this.EmergencyPriorityUpdatedEvent = EmergencyPriorityUpdatedEvent;
    }

    @Bean
    public TopicExchange EmergencyPriorityUpdatedEvent(){
        return new TopicExchange(RabbitMQconstant.EMERGENCY_EXCHANGE);
    }
 
    @Bean
    public Queue EmergencyPriorityUpdatedQueue(){
        return QueueBuilder.durable(RabbitMQconstant.EMERGENCY_PRIORITY_UPDATED_QUEUE).build();
    }

    @Bean
    public Binding ResponderUpdatedPriorityBinding(TopicExchange EmergencyPriorityUpdatedEvent,Queue EmergencyPriorityUpdatedQueue){
        return BindingBuilder.bind(EmergencyPriorityUpdatedQueue)
                             .to(EmergencyPriorityUpdatedEvent)
                             .with(RabbitMQconstant.EMERGENCY_PRIORITY_UPDATED_ROUTING_KEY);
    }

    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
 
    @Bean
    public Queue HospitalAssignedQueue(){
        return QueueBuilder.durable(RabbitMQconstant.HOSPITAL_ASSIGNED_QUEUE).build();
    }

    @Bean
    public Binding HospitalAssignedBinding(TopicExchange EmergencyPriorityUpdatedEvent,Queue HospitalAssignedQueue){
        return BindingBuilder.bind(HospitalAssignedQueue)
                             .to(EmergencyPriorityUpdatedEvent)
                             .with(RabbitMQconstant.HOSPITAL_ASSIGNED_ROUTING_KEY);
    }
    @Bean
    public Queue responderAssignedQueue(){
        return QueueBuilder.durable(RabbitMQconstant.RESPONDER_ASSIGNED_QUEUE).build();

    }

    @Bean
    public Binding responderAssignedBinding(TopicExchange EmergencyPriorityUpdateEvent,Queue responderAssignedQueue){
        return BindingBuilder.bind(responderAssignedQueue)
                             .to(EmergencyPriorityUpdateEvent)
                             .with(RabbitMQconstant.RESPONDER_ASSIGNED_ROUTING_KEY);
    }
}
