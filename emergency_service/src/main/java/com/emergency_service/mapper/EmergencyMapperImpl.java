package com.emergency_service.mapper;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.emergency_service.DTO.Request.EmergencyRequestDTO;
import com.emergency_service.DTO.Response.EmergencyResponseDTO;
import com.emergency_service.Entity.EmergencyRequest;
import com.emergency_service.event.model.EmergencyCreatedEvent;

@Component
public class EmergencyMapperImpl implements EmergencyMapper {
    @Override public EmergencyRequest toEntity(EmergencyRequestDTO dto, UUID userId) {
        EmergencyRequest entity = new EmergencyRequest();
        entity.setUserId(userId);
        if (dto != null) {
            entity.setEmergencyType(dto.getEmergencyType()); entity.setLatitude(dto.getLatitude());
            entity.setLongitude(dto.getLongitude()); entity.setAddress(dto.getAddress());
            entity.setPriority(dto.getPriority());
        }
        return entity;
    }
    @Override public EmergencyResponseDTO toResponse(EmergencyRequest entity) {
        if (entity == null) return null;
        EmergencyResponseDTO response = new EmergencyResponseDTO();
        response.setEmergencyId(entity.getEmergencyId()); response.setUserId(entity.getUserId());
        response.setEmergencyType(entity.getEmergencyType()); response.setStatus(entity.getStatus());
        response.setLatitude(entity.getLatitude()); response.setLongitude(entity.getLongitude());
        response.setAddress(entity.getAddress()); response.setResponderId(entity.getResponderId());
        response.setHospitalId(entity.getHospitalId()); response.setPriority(entity.getPriority());
        response.setDescription(entity.getDescription()); response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt()); response.setActive(entity.isActive());
        return response;
    }
    @Override public EmergencyCreatedEvent toCreatedEvent(EmergencyRequest entity) {
        if (entity == null) return null;
        EmergencyCreatedEvent event = new EmergencyCreatedEvent();
        event.setEmergencyId(entity.getEmergencyId()); event.setUserId(entity.getUserId());
        event.setEmergencyType(entity.getEmergencyType()); event.setLatitude(entity.getLatitude());
        event.setLongitude(entity.getLongitude()); event.setPriority(entity.getPriority());
        event.setCreatedAt(entity.getCreatedAt()); return event;
    }
}
