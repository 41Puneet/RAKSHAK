package com.emergency_service.mapper;


import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.emergency_service.DTO.Request.EmergencyRequestDTO;
import com.emergency_service.Entity.EmergencyRequest;


@Mapper(componentModel="spring")
public interface EmergencyMapper {
    @Mapping(target="status", ignore=true)
    @Mapping(target="responderId",ignore=true)
    @Mapping(target="hospitalId",ignore=true)
    @Mapping(target="Active",ignore=true)
    @Mapping(target="emergencyId",ignore=true)
    @Mapping(target="userId",source="userId")
    @Mapping(target="images",ignore=true)
    @Mapping(target="assignments",ignore=true)
    @Mapping(target="locationHistory",ignore=true)
    @Mapping(target="createdAt",ignore=true)
    @Mapping(target="updatedAt",ignore=true)
    EmergencyRequest toEntity(EmergencyRequestDTO dto,UUID userId);
}
