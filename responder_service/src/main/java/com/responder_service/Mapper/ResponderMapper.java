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
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResponderMapper {

    @Mapping(target="id", ignore = true)
    @Mapping(target="status",ignore=true)
    @Mapping(target="dutyStatus",ignore=true)
    @Mapping(target="latitude",ignore=true)
    @Mapping(target="longitude",ignore=true)
    @Mapping(target="active",ignore=true)
    @Mapping(target="createdAt",ignore=true)
    @Mapping(target="updatedAt",ignore=true)
    @Mapping(target="location",ignore=true)
    @Mapping(target="history",ignore=true)
    @Mapping(target="assignments",ignore=true)
    @Mapping(target="responderVehicle",ignore=true)
    Responder toEntity(CreateResponderRequest request);

    default Responder toResponderEntity(CreateResponderRequest request) {
        return toEntity(request);
    }

    
    ResponderResponse toResponse(Responder responder);

    default ResponderResponse toResponderResponse(Responder responder) {
        return toResponse(responder);
    }


    @Mapping(target="id",ignore=true)
    @Mapping(target="active",ignore=true)
    ResponderVehicle toEntity(RegisterVehicleRequest request);

    VehicleResponse toResponse(ResponderVehicle vehicle);

    default VehicleResponse toVehicleResponse(ResponderVehicle vehicle) {
        return toResponse(vehicle);
    }

    AssignmentResponse toAssignmentResponse(ResponderAssignment assignment);

    AvailabilityHistoryResponse toResponse(
            ResponderAvailabilityHistory history);

    default AvailabilityHistoryResponse toAvailabilityResponse(
            ResponderAvailabilityHistory history) {
        return toResponse(history);
    }

    LocationHistoryResponse toResponse(
            ResponderLocationHistory history);

    default LocationHistoryResponse toResponderLocationResponse(
            ResponderLocationHistory history) {
        return toResponse(history);
    }
}
