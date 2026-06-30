package com.emergency_service.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.emergency_service.Enums.EmergencyType;
import com.emergency_service.DTO.Request.EmergencyRequestDTO;
import com.emergency_service.DTO.Response.EmergencyResponseDTO;
import com.emergency_service.Enums.Priority;
import com.emergency_service.Enums.Status;
import com.emergency_service.DTO.Request.EmergencyImageRequestDTO;

public interface EmergencyService {
    EmergencyResponseDTO createEmergency(EmergencyRequestDTO dto);

    void cancelEmergency(UUID emergencyId);

    void uploadImages(UUID emergencyId,EmergencyImageRequestDTO dto);

    EmergencyResponseDTO getEmergencyById(UUID emergencyId);

    Page<EmergencyResponseDTO> getEmergencyByUserId(UUID userId,Pageable pageable);

    Page<EmergencyResponseDTO> getEmergencyByStatus(Status status,Pageable pageable);

    Page<EmergencyResponseDTO> getEmergencyByPriority(Priority priority,Pageable pageable);

    Page<EmergencyResponseDTO> getEmergencyByCreatedAtBetween(LocalDateTime createdAt,LocalDateTime endTime,Pageable pageable);

    Page<EmergencyResponseDTO> getEmergencyByActiveTrue(boolean isActive,Pageable pageable);

    Page<EmergencyResponseDTO> getEmergencyByType(EmergencyType type,Pageable pageable);

    Optional<EmergencyResponseDTO> getActiveEmergencyByUserId(UUID userId);

    Page<EmergencyResponseDTO> getEmergencyByResponderId(UUID responderId,Pageable pageable);

    Page<EmergencyResponseDTO> getAllEmergencies(Pageable pageable);

}
