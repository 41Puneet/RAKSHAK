package com.tracking_service.Mapper;

import org.springframework.stereotype.Component;

import com.tracking_service.DTO.Request.LocationUpdateRequest;
import com.tracking_service.DTO.Response.LocationResponse;
import com.tracking_service.Entity.CurrentLocation;
import com.tracking_service.Entity.LocationHistory;
import com.tracking_service.RabbitMQevent.event.LocationUpdatedEvent;

@Component
public class TrackingMapperImpl implements TrackingMapper {

    @Override
    public CurrentLocation toCurrentLocation(LocationUpdateRequest request) {
        if (request == null) {
            return null;
        }

        CurrentLocation currentLocation = new CurrentLocation();
        currentLocation.setEntityId(request.getEntityId());
        currentLocation.setEntityType(request.getEntityType());
        currentLocation.setLatitude(request.getLatitude());
        currentLocation.setLongitude(request.getLongitude());
        currentLocation.setTimestamp(request.getTimestamp());
        return currentLocation;
    }

    @Override
    public LocationHistory toLocationHistory(LocationUpdateRequest request) {
        if (request == null) {
            return null;
        }

        LocationHistory history = new LocationHistory();
        history.setEntityId(request.getEntityId());
        history.setEntityType(request.getEntityType());
        history.setLatitude(request.getLatitude());
        history.setLongitude(request.getLongitude());
        history.setTimestamp(request.getTimestamp());
        return history;
    }

    @Override
    public LocationResponse toLocationResponse(CurrentLocation currentLocation) {
        if (currentLocation == null) {
            return null;
        }

        LocationResponse response = new LocationResponse();
        response.setId(currentLocation.getId());
        response.setEntityId(currentLocation.getEntityId());
        response.setEntityType(null);
        response.setLatitude(currentLocation.getLatitude());
        response.setLongitude(currentLocation.getLongitude());
        response.setTimestamp(currentLocation.getTimestamp());
        return response;
    }

    @Override
    public LocationResponse toLocationResponse(LocationHistory locationHistory) {
        if (locationHistory == null) {
            return null;
        }

        LocationResponse response = new LocationResponse();
        response.setId(locationHistory.getId());
        response.setEntityId(locationHistory.getEntityId());
        response.setEntityType(null);
        response.setLatitude(locationHistory.getLatitude());
        response.setLongitude(locationHistory.getLongitude());
        response.setTimestamp(locationHistory.getTimestamp());
        return response;
    }

    @Override
    public LocationUpdatedEvent toLocationUpdatedEvent(CurrentLocation currentLocation) {
        if (currentLocation == null) {
            return null;
        }

        LocationUpdatedEvent event = new LocationUpdatedEvent();
        event.setEntityId(currentLocation.getEntityId());
        event.setEntityType(null);
        event.setLatitude(currentLocation.getLatitude());
        event.setLongitude(currentLocation.getLongitude());
        event.setTimestamp(currentLocation.getTimestamp());
        return event;
    }
}
