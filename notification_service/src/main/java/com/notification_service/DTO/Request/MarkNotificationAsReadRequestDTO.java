package com.notification_service.DTO.Request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class MarkNotificationAsReadRequestDTO {

    @NotNull(message = "notificationId is required")
    private UUID notificationId;

    public MarkNotificationAsReadRequestDTO() {
    }

    public MarkNotificationAsReadRequestDTO(UUID notificationId) {
        this.notificationId = notificationId;
    }

    public UUID getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(UUID notificationId) {
        this.notificationId = notificationId;
    }
}
