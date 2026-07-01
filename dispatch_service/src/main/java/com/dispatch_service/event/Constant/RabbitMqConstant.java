package com.dispatch_service.event.Constant;

public class RabbitMqConstant {
    
    public static final String EMERGENCY_EXCHANGE = "emergency.exchange";

    public static final String EMERGENCY_CREATED_QUEUE = "emergency_created_queue";
    public static final String EMERGENCY_CREATED_ROUTING_KEY = "emergency.created";


    public static final String RESPONDER_ASSIGNED_QUEUE="responder_assigned_queue";
    public static final String RESPONDER_ASSIGNED_ROUTING_KEY="responder.assigned";
}
