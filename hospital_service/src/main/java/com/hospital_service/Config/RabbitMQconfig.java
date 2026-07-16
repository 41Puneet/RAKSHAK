package com.hospital_service.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;


import com.hospital_service.Event.RabbitMqConstant.RabbitMQconstant;

@Configuration
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
    public Binding HospitalAssignedBinding(
        @Qualifier("HospitalAssignedQueue") Queue HospitalAssignedQueue,
        @Qualifier("EmergencyExchange") TopicExchange EmergencyExchange){
        return BindingBuilder.bind(HospitalAssignedQueue)
                             .to(EmergencyExchange)
                             .with(RabbitMQconstant.HOSPITAL_ASSIGNED_ROUTING_KEY);
    }

    @Bean
    public Queue emergencyPriorityUpdatedQueue(){
        return QueueBuilder.durable(RabbitMQconstant.EMERGENCY_PRIORITY_UPDATED_QUEUE).build();
    }

    @Bean
    public Binding emergencyPriorityUpdateBinding(
        @Qualifier("EmergencyExchange") TopicExchange emergencyExchange,
        @Qualifier("emergencyPriorityUpdatedQueue") Queue emergencyPriorityUpdateQueue){
       return BindingBuilder.bind(emergencyPriorityUpdateQueue)
                            .to(emergencyExchange)
                            .with(RabbitMQconstant.EMERGENCY_PRIORITY_UPDATED_ROUTING_KEY);

    }
}
