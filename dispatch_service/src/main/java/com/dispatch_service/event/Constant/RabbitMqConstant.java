package com.dispatch_service.event.Constant;

public class RabbitMqConstant {
    
     public static final String EMERGENCY_EXCHANGE = "emergency.exchange";

    // Queue
    public static final String EMERGENCY_CREATED_QUEUE = "emergency.created.queue";

    // Routing Key
    public static final String EMERGENCY_CREATED_ROUTING_KEY = "emergency.created";

    public static final String RESPONDER_ASSIGNED_QUEUE =
        "responder.assigned.queue";

    public static final String RESPONDER_ASSIGNED_ROUTING_KEY =
        "responder.assigned";


    // Routing Key
    public static final String LOCATION_UPDATED_ROUTING_KEY =
            "tracking.location.updated";

    public static final String LOCATION_UPDATE_QUEUE= "location.update.queue";


}
