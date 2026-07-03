package com.emergency_service.serviceImpl;

import java.util.UUID;
import com.emergency_service.DTO.Request.EmergencyImageRequestDTO;
import com.emergency_service.DTO.Request.EmergencyRequestDTO;
import com.emergency_service.DTO.Response.EmergencyResponseDTO;
import com.emergency_service.Entity.EmergencyRequest;
import com.emergency_service.Enums.Status;
import com.emergency_service.event.model.EmergencyCreatedEvent;
import com.emergency_service.event.producer.EmergencyEventProducer;
import com.emergency_service.Repository.EmergencyRepository;
import com.emergency_service.Service.EmergencyService;
import com.emergency_service.Repository.EmergencyImageRepository;
import com.emergency_service.mapper.EmergencyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EmergencyServiceImpl implements EmergencyService {

    private final EmergencyRepository emergencyRepository;
    private final EmergencyImageRepository emergencyImageRepository;
    private final EmergencyMapper emergencyMapper;
    private final EmergencyEventProducer emergencyEventProducer;

    public EmergencyServiceImpl(
            EmergencyRepository emergencyRepository,
            EmergencyImageRepository emergencyImageRepository,
            EmergencyMapper emergencyMapper,
            EmergencyEventProducer emergencyEventProducer) {

        this.emergencyRepository = emergencyRepository;
        this.emergencyImageRepository = emergencyImageRepository;
        this.emergencyMapper = emergencyMapper;
        this.emergencyEventProducer = emergencyEventProducer;
    }



    @Override
    public EmergencyResponseDTO cancelEmergency(UUID emergencyId) {
       EmergencyRequest emergency=emergencyRepository.findById(emergencyId).orElseThrow(()->new RuntimeException("Emergency not found with id:"+emergencyId));
       emergency.setActive(false);
       emergency.setStatus(Status.CANCELLED);
       emergencyRepository.save(emergency);
        return null;
    }
    private EmergencyCreatedEvent toEmergencyCreatedEvent(EmergencyRequest emergency){

    EmergencyCreatedEvent event =
            new EmergencyCreatedEvent();

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
    public EmergencyResponseDTO createEmergency(EmergencyRequestDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EmergencyResponseDTO getActiveEmergencyByUserId(UUID userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EmergencyResponseDTO getEmergencyById(UUID emergencyId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public EmergencyResponseDTO uploadImages(UUID emergencyId, EmergencyImageRequestDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
