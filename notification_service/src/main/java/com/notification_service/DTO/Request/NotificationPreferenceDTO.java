package com.notification_service.DTO.Request;

import java.util.List;
import java.util.UUID;

import com.notification_service.Enums.DeliveryChannel;
import com.notification_service.Enums.ReceiverType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class NotificationPreferenceDTO {

    @NotNull(message = "receiverId is required")
    private UUID receiverId;

    @NotNull(message = "receiverType is required")
    private ReceiverType receiverType;

    private boolean notificationsEnabled = true;

    @Size(max = 10, message = "preferredChannels cannot have more than 10 entries")
    private List<DeliveryChannel> preferredChannels;

    public NotificationPreferenceDTO() {
    }

    public NotificationPreferenceDTO(UUID receiverId, ReceiverType receiverType, boolean notificationsEnabled,
            List<DeliveryChannel> preferredChannels) {
        this.receiverId = receiverId;
        this.receiverType = receiverType;
        this.notificationsEnabled = notificationsEnabled;
        this.preferredChannels = preferredChannels;
    }

    public UUID getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(UUID receiverId) {
        this.receiverId = receiverId;
    }

    public ReceiverType getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(ReceiverType receiverType) {
        this.receiverType = receiverType;
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public List<DeliveryChannel> getPreferredChannels() {
        return preferredChannels;
    }

    public void setPreferredChannels(List<DeliveryChannel> preferredChannels) {
        this.preferredChannels = preferredChannels;
    }
}
