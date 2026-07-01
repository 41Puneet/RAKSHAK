package com.dispatch_service.Config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import com.dispatch_service.event.Constant.RabbitMqConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;



@Configuration
public class RabbitMqConfig {

@Bean
public TopicExchange emergencyExchange(){
    return new TopicExchange(RabbitMqConstant.EMERGENCY_EXCHANGE);
}

@Bean
public Queue responderAssignedQueue(){
    return QueueBuilder
        .durable(RabbitMqConstant.RESPONDER_ASSIGNED_QUEUE)
        .build();
}

@Bean
public Binding responderAssignedBinding(Queue responderAssignedQueue,TopicExchange emergencyExchange){
    return BindingBuilder.bind(responderAssignedQueue)
    .to(emergencyExchange)
    .with(RabbitMqConstant.RESPONDER_ASSIGNED_ROUTING_KEY);
}
@Bean
public MessageConverter messageConverter(){
    return new Jackson2JsonMessageConverter();
}

@Bean
public Queue emergencyCreatedQueue() {
    return QueueBuilder
            .durable(RabbitMqConstant.EMERGENCY_CREATED_QUEUE)
            .build();
}

@Bean
public Binding emergencyCreatedBinding(
        Queue emergencyCreatedQueue,
        TopicExchange emergencyExchange) {

    return BindingBuilder.bind(emergencyCreatedQueue)
            .to(emergencyExchange)
            .with(RabbitMqConstant.EMERGENCY_CREATED_ROUTING_KEY);
}
}
