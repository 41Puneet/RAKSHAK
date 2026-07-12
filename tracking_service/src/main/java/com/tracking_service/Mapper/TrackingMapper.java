package com.tracking_service.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tracking_service.DTO.Request.LocationUpdateRequest;
import com.tracking_service.DTO.Response.LocationResponse;
import com.tracking_service.Entity.CurrentLocation;
import com.tracking_service.Entity.LocationHistory;
import com.tracking_service.RabbitMQevent.event.LocationUpdatedEvent;

@Mapper(componentModel = "spring")
public interface TrackingMapper {
    

    @Mapping(target = "id",ignore=true)
   CurrentLocation toCurrentLocation(LocationUpdateRequest request);

   @Mapping(target="id",ignore=true)
    LocationHistory toLocationHistory(LocationUpdateRequest request);

    LocationResponse toLocationResponse(CurrentLocation currentLocation);

    LocationResponse toLocationResponse(LocationHistory locationHistory);

    LocationUpdatedEvent toLocationUpdatedEvent(CurrentLocation currentLocation);

}
