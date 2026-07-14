package com.responder_service.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.responder_service.DTO.request.AssignResponderRequest;
import com.responder_service.DTO.request.CompleteAssignmentRequest;
import com.responder_service.DTO.request.CreateResponderRequest;
import com.responder_service.DTO.request.RegisterVehicleRequest;
import com.responder_service.DTO.request.UpdateAvailabilityRequest;
import com.responder_service.DTO.request.UpdatePriorityStatus;
import com.responder_service.DTO.request.UpdateResponder;
import com.responder_service.DTO.request.UpdateVehicleRequest;
import com.responder_service.DTO.response.AssignmentResponse;
import com.responder_service.DTO.response.AvailabilityHistoryResponse;
import com.responder_service.DTO.response.LocationHistoryResponse;
import com.responder_service.DTO.response.PriorityResponse;
import com.responder_service.DTO.response.ResponderResponse;
import com.responder_service.DTO.response.VehicleResponse;
import com.responder_service.Enums.Assignment_Status;
import com.responder_service.event.model.ResponderAssignedEvent;

public interface ResponderService {
    

ResponderResponse createResponder(CreateResponderRequest request);

ResponderResponse updateResponder(UUID responderId,UpdateResponder request);

void deleteResponder(UUID responderId);

AssignmentResponse assignResponder(ResponderAssignedEvent event);

AssignmentResponse completeAssignment(CompleteAssignmentRequest request);

VehicleResponse registerVehicle(RegisterVehicleRequest request);

AvailabilityHistoryResponse updateAvailability(UpdateAvailabilityRequest request,UUID responderId);

VehicleResponse updateVehicle(UUID vehicleId,UpdateVehicleRequest request);

void deleteVehicle(UUID vehicleId);

ResponderResponse getResponderByID(UUID responderId);

VehicleResponse getVehicleByID(UUID vehicleId);
 
AssignmentResponse getAssignmentById(UUID assignmentId);

VehicleResponse getVehicleByResponder(UUID responderId);

AssignmentResponse updatePriorityofEmergency(UUID emegencyId,UUID responderId,Assignment_Status status,UpdatePriorityStatus request);




// for the control room
Page<AssignmentResponse> getAssignmentResponseByResponderId(UUID responderId,Pageable pageable);

Page<AssignmentResponse> getByAssignmentStatus(UUID responderId,Assignment_Status status,Pageable pageable);

Page<AvailabilityHistoryResponse> getAvailabilityByResponderId(UUID responderId,Pageable pageable);

Page<LocationHistoryResponse> getLocationByResponderId(UUID responderId,Pageable pageable);

LocationHistoryResponse getByResponderIdAndTime(UUID responderId);

Page<LocationHistoryResponse> getByTimeBetween(LocalDateTime start,LocalDateTime end,Pageable pageable);

Page<VehicleResponse> getByActiveVehicle(boolean active,Pageable pageable);



}
