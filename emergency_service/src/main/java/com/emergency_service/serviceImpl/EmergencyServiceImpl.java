package com.emergency_service.serviceImpl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.emergency_service.Entity.EmergencyImage;
import com.emergency_service.Entity.EmergencyRequest;
import com.emergency_service.Enums.Status;
import com.emergency_service.DTO.Request.EmergencyImageRequestDTO;
import com.emergency_service.DTO.Request.EmergencyRequestDTO;
import com.emergency_service.DTO.Response.EmergencyResponseDTO;
import com.emergency_service.Service.EmergencyService;
import com.emergency_service.mapper.EmergencyMapper;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import com.emergency_service.event.model.EmergencyCreatedEvent;
import com.emergency_service.event.producer.EmergencyEventProducer;
import com.emergency_service.Repository.EmergencyRepository;

@Service
@Transactional
public class EmergencyServiceImpl implements EmergencyService {

    private final EmergencyRepository emergencyRepository;
    private final EmergencyMapper emergencyMapper;
    private final EmergencyEventProducer emergencyEventProducer;

    public EmergencyServiceImpl(EmergencyRepository emergencyRepository, EmergencyMapper emergencyMapper, EmergencyEventProducer emergencyEventProducer) {
        this.emergencyRepository = emergencyRepository;
        this.emergencyMapper = emergencyMapper;
        this.emergencyEventProducer = emergencyEventProducer;
    }

    @Override
    public EmergencyResponseDTO cancelEmergency(UUID emergencyId) {
    EmergencyRequest emergencyRequest = emergencyRepository.findById(emergencyId)
            .orElseThrow(() -> new RuntimeException("Emergency request not found with ID: " + emergencyId));
    emergencyRequest.setActive(false);
    emergencyRequest.setStatus(Status.CANCELLED);
    emergencyRequest.setUpdatedAt(LocalDateTime.now());
    emergencyRepository.save(emergencyRequest);
        return emergencyMapper.toResponse(emergencyRequest);
    }

    @Override
    public EmergencyResponseDTO createEmergency(EmergencyRequestDTO dto, UUID userId) {
        EmergencyRequest emergencyRequest = emergencyMapper.toEntity(dto, userId);
        emergencyRequest.setStatus(Status.CREATED);
        emergencyRequest.setActive(true);
        emergencyRequest.setResponderId(null);
        emergencyRequest.setHospitalId(null);
        emergencyRequest.setCreatedAt(java.time.LocalDateTime.now());
        emergencyRequest.setUpdatedAt(java.time.LocalDateTime.now());
        EmergencyRequest savedEmergency = emergencyRepository.save(emergencyRequest);

        EmergencyCreatedEvent event = toEmergencyCreatedEvent(savedEmergency);
emergencyEventProducer.publishEmergencyCreated(event);
        return emergencyMapper.toResponse(savedEmergency);
 
    }
    private EmergencyCreatedEvent toEmergencyCreatedEvent(EmergencyRequest emergency) {
    EmergencyCreatedEvent event = new EmergencyCreatedEvent();
    event.setEmergencyId(emergency.getEmergencyId());
    event.setUserId(emergency.getUserId());
    event.setEmergencyType(emergency.getEmergencyType());
    event.setLatitude(emergency.getLatitude());
    event.setLongitude(emergency.getLongitude());
    event.setPriority(emergency.getPriority());
    event.setCreatedAt(emergency.getCreatedAt());
    return event;
}

    @Override
    public EmergencyResponseDTO getActiveEmergencyByUserId(UUID userId) {
        Optional<EmergencyRequest> activeEmergency = emergencyRepository.findActiveEmergency(userId);
        return activeEmergency.map(emergencyMapper::toResponse).orElse(null);
    }

    @Override
    public EmergencyResponseDTO getEmergencyById(UUID emergencyId) {
        EmergencyRequest emergencyRequest = emergencyRepository.findById(emergencyId)
                .orElseThrow(() -> new IllegalArgumentException("Emergency request not found with ID: " + emergencyId));
        return emergencyMapper.toResponse(emergencyRequest);
    }

    @Override
    public EmergencyResponseDTO uploadImages(UUID emergencyId, EmergencyImageRequestDTO dto) {
        // Verify emergency exists and load it
        Optional<EmergencyRequest> optionalEmergency = emergencyRepository.findById(emergencyId);
        EmergencyRequest emergency = optionalEmergency.orElseThrow(() -> new RuntimeException("Emergency request not found with ID: " + emergencyId));

        for (String url : dto.getImgUrl()) {
            EmergencyImage image = new EmergencyImage();
            image.setImageUrl(url);
            image.setUploadedAt(LocalDateTime.now());
            image.setEmergencyRequest(emergency);

            // initialize images collection if null
            if (emergency.getImages() == null) {
                emergency.setImages(new java.util.ArrayList<>());
            }

            emergency.getImages().add(image);
        }

        EmergencyRequest saved = emergencyRepository.save(emergency);
        return emergencyMapper.toResponse(saved);
    }
    
}
