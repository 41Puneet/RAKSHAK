package com.notification_service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.notification_service.DTO.Request.SendNotificationRequestDTO;
import com.notification_service.Entity.Notification;
import com.notification_service.Enums.*;
import com.notification_service.Mapper.NotificationMapper;
import com.notification_service.Repository.NotificationRepository;
import com.notification_service.Service.NotificationService;
import com.notification_service.DTO.Response.NotificationResponseDTO;

@ExtendWith(MockitoExtension.class)
class NotificationServiceUnitTest {
    @Mock NotificationRepository repository;
    @Mock NotificationMapper mapper;
    @InjectMocks NotificationService service;
    @Test void createIsIdempotentForReferenceAndType(){
        UUID reference=UUID.randomUUID(); UUID receiver=UUID.randomUUID();
        SendNotificationRequestDTO request=new SendNotificationRequestDTO(receiver,ReceiverType.USER,"title","message",NotificationType.EMERGENCY_CREATED,DeliveryChannel.PUSH,reference);
        Notification existing=new Notification(); NotificationResponseDTO response=new NotificationResponseDTO();
        when(repository.existsByReferenceIdAndNotificationType(reference,NotificationType.EMERGENCY_CREATED)).thenReturn(true);
        when(repository.findByReceiverId(receiver)).thenReturn(java.util.List.of(existing));
        existing.setReferenceId(reference); existing.setNotificationType(NotificationType.EMERGENCY_CREATED);
        when(mapper.toResponseDTO(existing)).thenReturn(response);
        assertSame(response,service.create(request)); verify(repository,never()).save(any());
    }
}
