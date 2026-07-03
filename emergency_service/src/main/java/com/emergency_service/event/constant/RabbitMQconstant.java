package com.emergency_service.event.constant;

public class RabbitMQconstant {
    private RabbitMQconstant() {
        // Prevent instantiation
    }

    // Exchange
    public static final String EMERGENCY_EXCHANGE = "emergency.exchange";

    // Queue
    public static final String EMERGENCY_CREATED_QUEUE = "emergency.created.queue";

    // Routing Key
    public static final String EMERGENCY_CREATED_ROUTING_KEY = "emergency.created";

    public static final String RESPONDER_ASSIGNED_QUEUE =
        "responder.assigned.queue";

    public static final String RESPONDER_ASSIGNED_ROUTING_KEY =
        "responder.assigned";
}
