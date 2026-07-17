package com.notification_service.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.notification_service.Entity.Notification;
import com.notification_service.Enums.NotificationStatus;

public interface NotificationRepository extends JpaRepository<Notification,UUID> {
    
   List<Notification> findByReceiverId(UUID receiverId);
   List<Notification> findByReceiverIdAndNotificationStatus(UUID receiverId,NotificationStatus status);

   Page <Notification> findByReceiverId(UUID receiverId,Pageable pageable);

}
