package com.tracking_service.RabbitMQevent.Constant;
public final class RabbitMQConstants {

    private RabbitMQConstants() {}

    // Exchange
    public static final String EMERGENCY_EXCHANGE = "emergency.exchange";

    // Routing Key
    public static final String LOCATION_UPDATED_ROUTING_KEY =
            "tracking.location.updated";

}