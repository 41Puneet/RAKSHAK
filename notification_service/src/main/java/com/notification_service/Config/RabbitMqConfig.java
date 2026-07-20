package com.notification_service.Config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.notification_service.event.RabbitMqConstant.RabbitMQConstants;
import com.rabbitmq.client.AMQP.Queue;

@Configuration
public class RabbitMqConfig {
    

    @Bean
    public TopicExchange emergencyExchange(){
        return new TopicExchange(RabbitMQConstants.EMERGENCY_EXCHANGE);
    }


}
