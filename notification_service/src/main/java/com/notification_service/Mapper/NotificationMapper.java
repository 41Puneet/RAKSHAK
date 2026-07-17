package com.notification_service.Mapper;

import com.notification_service.DTO.Request.SendNotificationRequestDTO;
import com.notification_service.DTO.Response.NotificationLogResponseDTO;
import com.notification_service.DTO.Response.NotificationResponseDTO;
import com.notification_service.Entity.Notification;
import com.notification_service.Entity.NotificationLogs;

public interface NotificationMapper {
    


    NotificationResponseDTO toResponseDTO(Notification notification);
    NotificationLogResponseDTO toResponseDTO(NotificationLogs notificationLog);
    Notification toEntity(SendNotificationRequestDTO dto);
}
