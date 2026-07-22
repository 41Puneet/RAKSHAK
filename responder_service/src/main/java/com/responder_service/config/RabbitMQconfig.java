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

    @Bean
    public TopicExchange emergencyExchange() {
        return new TopicExchange(RabbitMQconstant.EMERGENCY_EXCHANGE);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // =======================
    // Emergency Priority Updated
    // =======================

    @Bean
    public Queue emergencyPriorityUpdatedQueue() {
        return QueueBuilder
                .durable(RabbitMQconstant.EMERGENCY_PRIORITY_UPDATED_QUEUE)
                .build();
    }

    @Bean
    public Binding responderUpdatedPriorityBinding(
            TopicExchange emergencyExchange,
            Queue emergencyPriorityUpdatedQueue) {

        return BindingBuilder.bind(emergencyPriorityUpdatedQueue)
                .to(emergencyExchange)
                .with(RabbitMQconstant.EMERGENCY_PRIORITY_UPDATED_ROUTING_KEY);
    }

    // =======================
    // Hospital Assigned
    // =======================

    @Bean
    public Queue hospitalAssignedQueue() {
        return QueueBuilder
                .durable(RabbitMQconstant.HOSPITAL_ASSIGNED_QUEUE)
                .build();
    }

    @Bean
    public Binding hospitalAssignedBinding(
            TopicExchange emergencyExchange,
            Queue hospitalAssignedQueue) {

        return BindingBuilder.bind(hospitalAssignedQueue)
                .to(emergencyExchange)
                .with(RabbitMQconstant.HOSPITAL_ASSIGNED_ROUTING_KEY);
    }

    // =======================
    // Location Updated
    // =======================

    @Bean
    public Queue locationUpdatedQueue() {
        return QueueBuilder
                .durable(RabbitMQconstant.LOCATION_UPDATE_QUEUE)
                .build();
    }

    @Bean
    public Binding locationUpdateBinding(
            TopicExchange emergencyExchange,
            Queue locationUpdatedQueue) {

        return BindingBuilder.bind(locationUpdatedQueue)
                .to(emergencyExchange)
                .with(RabbitMQconstant.LOCATION_UPDATED_ROUTING_KEY);
    }
}