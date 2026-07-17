package com.notification_service.Mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.notification_service.DTO.Request.SendNotificationRequestDTO;
import com.notification_service.DTO.Response.NotificationLogResponseDTO;
import com.notification_service.DTO.Response.NotificationResponseDTO;
import com.notification_service.Entity.Notification;
import com.notification_service.Entity.NotificationLogs;
import com.notification_service.Enums.NotificationStatus;

@Component
public class NotificationMapperImpl implements NotificationMapper{

    @Override
    public Notification toEntity(SendNotificationRequestDTO dto) {
        Notification notification=new Notification();
        notification.setReceiverId(dto.getReceiverId());
        notification.setReceiverType(dto.getReceiverType());
        notification.setTitle(dto.getTitle());
        notification.setMessage(dto.getMessage());
        notification.setNotificationType(dto.getNotificationType());
        notification.setDeliveryChannel(dto.getDeliveryChannel());
        notification.setNotificationStatus(NotificationStatus.PENDING);
        notification.setReferenceId(dto.getReferenceId());
        notification.setCreatedAt(LocalDateTime.now());
        notification.setSentAt(null);
        notification.setReadAt(null);
       return notification;
    }

    @Override
    public NotificationResponseDTO toResponseDTO(Notification notification) {
       NotificationResponseDTO dto=new NotificationResponseDTO();
       dto.setId(notification.getId());
       dto.setReceiverId(notification.getReceiverId());
       dto.setReceiverType(notification.getReceiverType());
       dto.setTitle(notification.getTitle());
       dto.setMessage(notification.getMessage());
       dto.setNotificationType(notification.getNotificationType());
       dto.setDeliveryChannel(notification.getDeliveryChannel());
       dto.setNotificationStatus(notification.getNotificationStatus());
       dto.setReferenceId(notification.getReferenceId());
       dto.setCreatedAt(notification.getCreatedAt());
       dto.setSentAt(notification.getSentAt());
       dto.setReadAt(notification.getReadAt());
        return dto;
    }

    @Override
    public NotificationLogResponseDTO toResponseDTO(NotificationLogs notificationLog) {
      NotificationLogResponseDTO dto=new NotificationLogResponseDTO();
      dto.setId(notificationLog.getId());
      dto.setNotificationId(notificationLog.getNotification().getId());
      dto.setChannel(notificationLog.getChannel());
      dto.setStatus(notificationLog.getStatus());
      dto.setResponseMessage(notificationLog.getResponseMessage());
      dto.setRetryCount(notificationLog.getRetryCount());
      dto.setCreatedAt(notificationLog.getCreatedAt());
        return dto;
    }

}
