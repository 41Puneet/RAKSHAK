package com.emergency_service.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.emergency_service.DTO.Response.EmergencyResponseDTO;
import com.emergency_service.Enums.EmergencyType;
import com.emergency_service.Enums.Priority;
import com.emergency_service.Enums.Status;

public interface ControlRoomService {
    Page<EmergencyResponseDTO> getEmergencyByUserId(UUID userId,Pageable pageable);

    Page<EmergencyResponseDTO> getEmergencyByStatus(Status status,Pageable pageable);

    Page<EmergencyResponseDTO> getEmergencyByPriority(Priority priority,Pageable pageable);

    Page<EmergencyResponseDTO> getEmergencyByCreatedAtBetween(LocalDateTime createdAt,LocalDateTime endTime,Pageable pageable);

    Page<EmergencyResponseDTO> getEmergencyByActiveTrue(boolean isActive,Pageable pageable);

    Page<EmergencyResponseDTO> getEmergencyByType(EmergencyType type,Pageable pageable);

     Page<EmergencyResponseDTO> getEmergencyByResponderId(UUID responderId,Pageable pageable);

    
}
