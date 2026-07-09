package com.responder_service.ServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.responder_service.DTO.request.AssignResponderRequest;
import com.responder_service.DTO.request.CompleteAssignmentRequest;
import com.responder_service.DTO.request.CreateResponderRequest;
import com.responder_service.DTO.request.RegisterVehicleRequest;
import com.responder_service.DTO.request.UpdateAvailabilityRequest;
import com.responder_service.DTO.request.UpdateResponder;
import com.responder_service.DTO.request.UpdateVehicleRequest;
import com.responder_service.DTO.response.AssignmentResponse;
import com.responder_service.DTO.response.AvailabilityHistoryResponse;
import com.responder_service.DTO.response.LocationHistoryResponse;
import com.responder_service.DTO.response.ResponderResponse;
import com.responder_service.DTO.response.VehicleResponse;
import com.responder_service.Enums.Assignment_Status;
import com.responder_service.Mapper.ResponderMapper;
import com.responder_service.Repository.ResponderAssignmentRepository;
import com.responder_service.Repository.ResponderAvailabilityRepository;
import com.responder_service.Repository.ResponderLocationHistoryRepository;
import com.responder_service.Repository.ResponderRepository;
import com.responder_service.Repository.ResponderVehicleRepository;
import com.responder_service.service.ResponderService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResponderServiceImpl implements ResponderService {

private final ResponderAssignmentRepository assignmentRepository;
private final ResponderAvailabilityRepository availabilityRepository;
private final ResponderLocationHistoryRepository locationRepository;
private final ResponderRepository responderRepository;
private final ResponderVehicleRepository vehicleRepository;
private final ResponderMapper mapper;
private final Logger logger=LoggerFactory.getLogger(ResponderServiceImpl.class);
public ResponderServiceImpl(ResponderAssignmentRepository assignmentRepository, ResponderAvailabilityRepository availabilityRepository, ResponderLocationHistoryRepository locationRepository, ResponderRepository responderRepository, ResponderVehicleRepository vehicleRepository, ResponderMapper mapper) {
    this.assignmentRepository = assignmentRepository;
    this.availabilityRepository = availabilityRepository;
    this.locationRepository = locationRepository;
    this.responderRepository = responderRepository;
    this.vehicleRepository = vehicleRepository;
    this.mapper = mapper;
}
    @Override
    public AssignmentResponse assignResponder(AssignResponderRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AssignmentResponse completeAssignment(CompleteAssignmentRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponderResponse createResponder(CreateResponderRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteResponder(UUID responderId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteVehicle(UUID vehicleId) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public AssignmentResponse getAssignmentById(UUID assignmentId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<AssignmentResponse> getAssignmentResponseByResponderId(UUID responderId, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<AvailabilityHistoryResponse> getAvailabilityByResponderId(UUID responderId, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<VehicleResponse> getByActiveVehicle(boolean active, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<AssignmentResponse> getByAssignmentStatus(Assignment_Status status, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<AssignmentResponse> getByResponderIdAndStatus(UUID responderId, Assignment_Status status,
            Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<LocationHistoryResponse> getByResponderIdAndTime(UUID responderId) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Page<LocationHistoryResponse> getByTimeBetween(LocalDateTime start, LocalDateTime end, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<LocationHistoryResponse> getLocationByResponderId(UUID responderId, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponderResponse getResponderByID(UUID responderId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VehicleResponse getVehicleByID(UUID vehicleId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VehicleResponse getVehicleByResponder(UUID responderId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VehicleResponse registerVehicle(RegisterVehicleRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AvailabilityHistoryResponse updateAvailability(UpdateAvailabilityRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponderResponse updateResponder(UUID responderId, UpdateResponder request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VehicleResponse updateVehicle(UUID vehicleId, UpdateVehicleRequest request) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
