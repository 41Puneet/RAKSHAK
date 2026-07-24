package com.notification_service.Config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.retry.interceptor.RetryInterceptorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.notification_service.event.RabbitMqConstant.RabbitMQConstants;

@Configuration
public class RabbitMqConfig {
    

    @Bean
    public TopicExchange emergencyExchange(){
        return new TopicExchange(RabbitMQConstants.EMERGENCY_EXCHANGE);
    }

    @Bean public DirectExchange deadLetterExchange(){return new DirectExchange(RabbitMQConstants.EMERGENCY_EXCHANGE+".dlx");}
    @Bean public Queue notificationEmergencyCreatedQueue(){return durableQueue(RabbitMQConstants.NOTIFICATION_EMERGENCY_CREATED_QUEUE);}
    @Bean public Queue notificationHospitalAssignedQueue(){return durableQueue(RabbitMQConstants.NOTIFICATION_HOSPITAL_ASSIGNED_QUEUE);}
    @Bean public Binding emergencyCreatedBinding(){return BindingBuilder.bind(notificationEmergencyCreatedQueue()).to(emergencyExchange()).with(RabbitMQConstants.EMERGENCY_CREATED_ROUTING_KEY);}
    @Bean public Binding hospitalAssignedBinding(){return BindingBuilder.bind(notificationHospitalAssignedQueue()).to(emergencyExchange()).with(RabbitMQConstants.HOSPITAL_ASSIGNED_ROUTING_KEY);}
    private Queue durableQueue(String name){return QueueBuilder.durable(name).withArgument("x-dead-letter-exchange",RabbitMQConstants.EMERGENCY_EXCHANGE+".dlx").build();}
    @Bean public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory cf,RabbitTemplate template){
        SimpleRabbitListenerContainerFactory factory=new SimpleRabbitListenerContainerFactory(); factory.setConnectionFactory(cf); factory.setConcurrentConsumers(2); factory.setMaxConcurrentConsumers(8); factory.setDefaultRequeueRejected(false);
        factory.setAdviceChain(RetryInterceptorBuilder.stateless().maxAttempts(3).build()); return factory;
    }


}
