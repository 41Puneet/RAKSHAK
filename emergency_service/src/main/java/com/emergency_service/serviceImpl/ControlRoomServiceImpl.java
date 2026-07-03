package com.emergency_service.serviceImpl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emergency_service.DTO.Response.EmergencyResponseDTO;
import com.emergency_service.Entity.EmergencyRequest;
import com.emergency_service.Enums.EmergencyType;
import com.emergency_service.Enums.Priority;
import com.emergency_service.Enums.Status;
import com.emergency_service.Repository.EmergencyRepository;
import com.emergency_service.Service.ControlRoomService;
import com.emergency_service.mapper.EmergencyMapper;

@Service
public class ControlRoomServiceImpl implements ControlRoomService {

    private final EmergencyRepository emergencyRepository;
    private final EmergencyMapper mapper;

    public ControlRoomServiceImpl(EmergencyRepository emergencyRepository,
                                  EmergencyMapper mapper) {
        this.emergencyRepository = emergencyRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<EmergencyResponseDTO> getAllEmergencies(Pageable pageable) {
        return emergencyRepository
                .findAll(pageable)
                .map(mapper::toResponse);
    }

    @Override
    public Page<EmergencyResponseDTO> getEmergencyByUserId(UUID userId, Pageable pageable) {
        return emergencyRepository
                .findByUserId(userId, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public Page<EmergencyResponseDTO> getEmergencyByStatus(Status status, Pageable pageable) {
        return emergencyRepository
                .findByStatus(status, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public Page<EmergencyResponseDTO> getEmergencyByPriority(Priority priority, Pageable pageable) {
        return emergencyRepository
                .findByPriority(priority, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public Page<EmergencyResponseDTO> getEmergencyByCreatedAtBetween(
            LocalDateTime createdAt,
            LocalDateTime endTime,
            Pageable pageable) {

        return emergencyRepository
                .findByCreatedAtBetween(createdAt, endTime, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public Page<EmergencyResponseDTO> getEmergencyByActiveTrue(
            boolean isActive,
            Pageable pageable) {

        return emergencyRepository
                .findByIsActive(isActive, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public Page<EmergencyResponseDTO> getEmergencyByType(
            EmergencyType type,
            Pageable pageable) {

        return emergencyRepository
                .findByEmergencyType(type, pageable)
                .map(mapper::toResponse);
    }

    @Override
    public Page<EmergencyResponseDTO> getEmergencyByResponderId(
            UUID responderId,
            Pageable pageable) {

        return emergencyRepository
                .findByResponderId(responderId, pageable)
                .map(mapper::toResponse);
    }
}