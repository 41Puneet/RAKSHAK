package com.emergency_service.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.emergency_service.event.constant.RabbitMQconstant;

@Configuration
public class RabbitMQConfig {
    
    @Bean
    public TopicExchange emergencyExchange(){
        return new TopicExchange(RabbitMQconstant.EMERGENCY_EXCHANGE);

    }

    @Bean
    public Queue emergencyCreatedQueue(){
        return QueueBuilder.durable(RabbitMQconstant.EMERGENCY_CREATED_QUEUE).build();
    }

    @Bean
    public Binding emergencyCreatedBinding(Queue emergencyCreatedQueue, TopicExchange emergencyExchange){
        return BindingBuilder.bind(emergencyCreatedQueue)
                .to(emergencyExchange)
                .with(RabbitMQconstant.EMERGENCY_CREATED_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
