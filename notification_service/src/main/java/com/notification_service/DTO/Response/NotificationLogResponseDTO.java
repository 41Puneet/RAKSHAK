package com.notification_service.DTO.Response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.notification_service.Enums.DeliveryChannel;
import com.notification_service.Enums.NotificationStatus;

public class NotificationLogResponseDTO {

    private UUID id;
    private UUID notificationId;
    private DeliveryChannel channel;
    private NotificationStatus status;
    private String responseMessage;
    private int retryCount;
    private LocalDateTime createdAt;

    public NotificationLogResponseDTO() {
    }

    public NotificationLogResponseDTO(UUID id, UUID notificationId, DeliveryChannel channel,
            NotificationStatus status, String responseMessage, int retryCount, LocalDateTime createdAt) {
        this.id = id;
        this.notificationId = notificationId;
        this.channel = channel;
        this.status = status;
        this.responseMessage = responseMessage;
        this.retryCount = retryCount;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(UUID notificationId) {
        this.notificationId = notificationId;
    }

    public DeliveryChannel getChannel() {
        return channel;
    }

    public void setChannel(DeliveryChannel channel) {
        this.channel = channel;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
