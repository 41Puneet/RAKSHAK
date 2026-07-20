package com.notification_service.event.RabbitMqConstant;


public final class RabbitMQConstants {

    private RabbitMQConstants() {
    }

    // Existing exchange used across the system
    public static final String EMERGENCY_EXCHANGE = "emergency.exchange";

    // Notification queues
    public static final String NOTIFICATION_EMERGENCY_CREATED_QUEUE =
            "notification.emergency.created.queue";

    public static final String NOTIFICATION_RESPONDER_ASSIGNED_QUEUE =
            "notification.responder.assigned.queue";

    public static final String NOTIFICATION_RESPONDER_ARRIVED_QUEUE =
        "notification.responder.arrived.queue";

    public static final String NOTIFICATION_HOSPITAL_ASSIGNED_QUEUE =
            "notification.hospital.assigned.queue";

    public static final String NOTIFICATION_EMERGENCY_COMPLETED_QUEUE =
            "notification.emergency.completed.queue";

    public static final String NOTIFICATION_EMERGENCY_CANCELLED_QUEUE =
            "notification.emergency.cancelled.queue";

    public static final String NOTIFICATION_STATUS_UPDATED_QUEUE =
            "notification.emergency.status.updated.queue";

    // Routing keys (must match the publishers)
    public static final String EMERGENCY_CREATED_ROUTING_KEY =
            "emergency.created";

    public static final String RESPONDER_ASSIGNED_ROUTING_KEY =
            "responder.assigned";

    public static final String RESPONDER_ARRIVED_ROUTING_KEY =
            "responder.arrived";

    public static final String HOSPITAL_ASSIGNED_ROUTING_KEY =
            "hospital.assigned";

    public static final String EMERGENCY_COMPLETED_ROUTING_KEY =
            "emergency.completed";

    public static final String EMERGENCY_CANCELLED_ROUTING_KEY =
            "emergency.cancelled";

    public static final String EMERGENCY_STATUS_UPDATED_ROUTING_KEY =
            "emergency.status.updated";
}