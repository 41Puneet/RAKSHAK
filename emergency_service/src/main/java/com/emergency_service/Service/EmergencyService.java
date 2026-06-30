package com.emergency_service.Service;

import java.util.UUID;
import com.emergency_service.DTO.Request.EmergencyRequestDTO;
import com.emergency_service.DTO.Response.EmergencyResponseDTO;
import com.emergency_service.DTO.Request.EmergencyImageRequestDTO;

public interface EmergencyService {
   EmergencyResponseDTO createEmergency(EmergencyRequestDTO dto);

EmergencyResponseDTO cancelEmergency(UUID emergencyId);

EmergencyResponseDTO uploadImages(UUID emergencyId, EmergencyImageRequestDTO dto);

EmergencyResponseDTO getEmergencyById(UUID emergencyId);

EmergencyResponseDTO getActiveEmergencyByUserId(UUID userId);

   

}
