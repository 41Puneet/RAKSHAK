package com.notification_service.DTO.Request;

import java.util.UUID;

import com.notification_service.Enums.DeliveryChannel;
import com.notification_service.Enums.NotificationType;
import com.notification_service.Enums.ReceiverType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Notification request")
public class SendNotificationRequestDTO {

    @NotNull(message = "receiverId is required")
    private UUID receiverId;

    @NotNull(message = "receiverType is required")
    private ReceiverType receiverType;

    @NotBlank(message = "title is required")
    @jakarta.validation.constraints.Size(max = 160)
    private String title;

    @NotBlank(message = "message is required")
    @jakarta.validation.constraints.Size(max = 4000)
    private String message;

    @NotNull(message = "notificationType is required")
    private NotificationType notificationType;

    @NotNull(message = "deliveryChannel is required")
    private DeliveryChannel deliveryChannel;

    @NotNull(message = "referenceId is required")
    private UUID referenceId;

    public SendNotificationRequestDTO() {
    }

    public SendNotificationRequestDTO(UUID receiverId, ReceiverType receiverType, String title, String message,
            NotificationType notificationType, DeliveryChannel deliveryChannel, UUID referenceId) {
        this.receiverId = receiverId;
        this.receiverType = receiverType;
        this.title = title;
        this.message = message;
        this.notificationType = notificationType;
        this.deliveryChannel = deliveryChannel;
        this.referenceId = referenceId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public DeliveryChannel getDeliveryChannel() {
        return deliveryChannel;
    }

    public void setDeliveryChannel(DeliveryChannel deliveryChannel) {
        this.deliveryChannel = deliveryChannel;
    }

    public UUID getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(UUID referenceId) {
        this.referenceId = referenceId;
    }
}
