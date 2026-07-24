package com.notification_service.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.notification_service.DTO.Request.SendNotificationRequestDTO;
import com.notification_service.DTO.Response.NotificationResponseDTO;
import com.notification_service.Entity.Notification;
import com.notification_service.Enums.NotificationStatus;
import com.notification_service.Mapper.NotificationMapper;
import com.notification_service.Repository.NotificationRepository;

@Service @Transactional
public class NotificationService {
    private final NotificationRepository repository;
    private final NotificationMapper mapper;
    public NotificationService(NotificationRepository repository, NotificationMapper mapper){this.repository=repository;this.mapper=mapper;}
    public NotificationResponseDTO create(SendNotificationRequestDTO request){
        if(repository.existsByReferenceIdAndNotificationType(request.getReferenceId(),request.getNotificationType()))
            return repository.findByReceiverId(request.getReceiverId()).stream().filter(n->request.getReferenceId().equals(n.getReferenceId())&&request.getNotificationType()==n.getNotificationType()).findFirst().map(mapper::toResponseDTO).orElseThrow();
        return mapper.toResponseDTO(repository.save(mapper.toEntity(request)));
    }
    public Page<NotificationResponseDTO> list(UUID receiverId, Pageable pageable){return repository.findByReceiverId(receiverId,pageable).map(mapper::toResponseDTO);}
    public NotificationResponseDTO markRead(UUID receiverId, UUID id){
        Notification n=repository.findById(id).orElseThrow(()->new IllegalArgumentException("Notification not found"));
        if(!receiverId.equals(n.getReceiverId())) throw new IllegalArgumentException("Notification does not belong to the authenticated user");
        n.setNotificationStatus(NotificationStatus.READ); n.setReadAt(LocalDateTime.now()); return mapper.toResponseDTO(n);
    }
}
