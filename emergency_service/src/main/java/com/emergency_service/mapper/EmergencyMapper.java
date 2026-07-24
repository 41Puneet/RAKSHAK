package com.emergency_service.mapper;


import java.util.UUID;

import org.springframework.stereotype.Component;

import com.emergency_service.DTO.Request.EmergencyRequestDTO;
import com.emergency_service.DTO.Response.EmergencyResponseDTO;
import com.emergency_service.Entity.EmergencyRequest;
import com.emergency_service.event.model.EmergencyCreatedEvent;


@Component
public interface EmergencyMapper {
    EmergencyRequest toEntity(EmergencyRequestDTO dto,UUID userId);



    
    EmergencyResponseDTO toResponse(EmergencyRequest request);

    EmergencyCreatedEvent toCreatedEvent(EmergencyRequest entity);
}
