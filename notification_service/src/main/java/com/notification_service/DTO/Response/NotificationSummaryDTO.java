package com.notification_service.DTO.Response;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationSummaryDTO {

    private UUID receiverId;
    private long totalNotifications;
    private long unreadNotifications;
    private long readNotifications;
    private long failedNotifications;
    private LocalDateTime lastNotificationAt;

    public NotificationSummaryDTO() {
    }

    public NotificationSummaryDTO(UUID receiverId, long totalNotifications, long unreadNotifications,
            long readNotifications, long failedNotifications, LocalDateTime lastNotificationAt) {
        this.receiverId = receiverId;
        this.totalNotifications = totalNotifications;
        this.unreadNotifications = unreadNotifications;
        this.readNotifications = readNotifications;
        this.failedNotifications = failedNotifications;
        this.lastNotificationAt = lastNotificationAt;
    }

    public UUID getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(UUID receiverId) {
        this.receiverId = receiverId;
    }

    public long getTotalNotifications() {
        return totalNotifications;
    }

    public void setTotalNotifications(long totalNotifications) {
        this.totalNotifications = totalNotifications;
    }

    public long getUnreadNotifications() {
        return unreadNotifications;
    }

    public void setUnreadNotifications(long unreadNotifications) {
        this.unreadNotifications = unreadNotifications;
    }

    public long getReadNotifications() {
        return readNotifications;
    }

    public void setReadNotifications(long readNotifications) {
        this.readNotifications = readNotifications;
    }

    public long getFailedNotifications() {
        return failedNotifications;
    }

    public void setFailedNotifications(long failedNotifications) {
        this.failedNotifications = failedNotifications;
    }

    public LocalDateTime getLastNotificationAt() {
        return lastNotificationAt;
    }

    public void setLastNotificationAt(LocalDateTime lastNotificationAt) {
        this.lastNotificationAt = lastNotificationAt;
    }
}
