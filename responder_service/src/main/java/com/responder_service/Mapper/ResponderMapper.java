package com.responder_service.Mapper;

import com.responder_service.DTO.request.CreateResponderRequest;
import com.responder_service.DTO.request.RegisterVehicleRequest;
import com.responder_service.DTO.response.AssignmentResponse;
import com.responder_service.DTO.response.AvailabilityHistoryResponse;
import com.responder_service.DTO.response.LocationHistoryResponse;
import com.responder_service.DTO.response.ResponderResponse;
import com.responder_service.DTO.response.VehicleResponse;
import com.responder_service.Entity.Responder;
import com.responder_service.Entity.ResponderAssignment;
import com.responder_service.Entity.ResponderVehicle;
import com.responder_service.Entity.ResponderAvailabilityHistory;
import com.responder_service.Entity.ResponderLocationHistory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponderMapper {

        Responder toEntity(CreateResponderRequest request);

    ResponderResponse toResponse(Responder responder);

    ResponderVehicle toEntity(RegisterVehicleRequest request);

    VehicleResponse toResponse(ResponderVehicle vehicle);

    AssignmentResponse toResponse(ResponderAssignment assignment);

    AvailabilityHistoryResponse toResponse(
            ResponderAvailabilityHistory history);

    LocationHistoryResponse toResponse(
            ResponderLocationHistory history);
}