package com.notification_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.notification_service.Enums.DeliveryChannel;
import com.notification_service.Enums.NotificationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="notification_logs")
public class NotificationLogs {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private DeliveryChannel channel;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private NotificationStatus status;
    private String responseMessage;
    @Column(nullable=false)
    private int retryCount;
    @Column(nullable=false)
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="notification_id")
    private Notification notification;

    public NotificationLogs(){

    }
    public NotificationLogs(UUID id,DeliveryChannel channel,NotificationStatus status,String responseMessage,int retryCount,LocalDateTime createdAt,Notification notification){
        this.id=id;
        this.channel=channel;
        this.status=status;
        this.responseMessage=responseMessage;
        this.retryCount=retryCount;
        this.createdAt=createdAt;
        this.notification=notification;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
    public Notification getNotification() {
        return notification;
    }
    public void setNotification(Notification notification) {
        this.notification = notification;
    }
    
}
