package com.notification_service.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notification_service.Entity.NotificationLogs;

public interface NotificationLogRepository extends JpaRepository<NotificationLogs,UUID> {
    
    List<NotificationLogs> findByNotificationId(UUID notificationId);

    
}
