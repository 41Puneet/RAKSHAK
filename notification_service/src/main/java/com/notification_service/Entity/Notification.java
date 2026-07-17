package com.notification_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.notification_service.Enums.DeliveryChannel;
import com.notification_service.Enums.NotificationStatus;
import com.notification_service.Enums.NotificationType;
import com.notification_service.Enums.ReceiverType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="notifications")
public class Notification {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id;
@Column(nullable=false)
private UUID receiverId;
@Enumerated(EnumType.STRING)
@Column(nullable=false)
private ReceiverType receiverType;
@Column(nullable=false)
private String title;
@Column(nullable=false)
private String message;
@Enumerated(EnumType.STRING)
@Column(nullable=false)
private NotificationType notificationType;
@Enumerated(EnumType.STRING)
@Column(nullable=false)
private DeliveryChannel deliveryChannel;
@Enumerated(EnumType.STRING)
@Column(nullable=false)
private NotificationStatus notificationStatus;
@Column(nullable=false)
private UUID referenceId;
@Column(nullable=false)
private LocalDateTime createdAt;
@Column(nullable=false)
private LocalDateTime sentAt;
@Column(nullable=false)
private LocalDateTime readAt;

public Notification(){

}
public Notification(UUID id,UUID receiverId,ReceiverType receiverType,String title,String message,NotificationType notificationType,NotificationStatus notificationStatus,DeliveryChannel deliveryChannel,UUID referenceId,LocalDateTime createdAt,LocalDateTime sentAt,LocalDateTime readAt){
    this.id=id;
    this.receiverId=receiverId;
    this.receiverType=receiverType;
    this.title=title;
    this.message=message;
    this.notificationType=notificationType;
    this.deliveryChannel=deliveryChannel;
    this.notificationStatus=notificationStatus;
    this.referenceId=referenceId;
    this.createdAt=createdAt;
    this.sentAt=sentAt;
    this.readAt=readAt;
}
public UUID getId() {
    return id;
}
public void setId(UUID id) {
    this.id = id;
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
public NotificationStatus getNotificationStatus() {
    return notificationStatus;
}
public void setNotificationStatus(NotificationStatus notificationStatus) {
    this.notificationStatus = notificationStatus;
}
public UUID getReferenceId() {
    return referenceId;
}
public void setReferenceId(UUID referenceId) {
    this.referenceId = referenceId;
}
public LocalDateTime getCreatedAt() {
    return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}
public LocalDateTime getSentAt() {
    return sentAt;
}
public void setSentAt(LocalDateTime sentAt) {
    this.sentAt = sentAt;
}
public LocalDateTime getReadAt() {
    return readAt;
}
public void setReadAt(LocalDateTime readAt) {
    this.readAt = readAt;
}

}
