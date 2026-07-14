package com.responder_service.event.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.responder_service.Enums.EntityType;

public class LocationUpdatedEvent {
    
    private UUID entityId;
    private EntityType entityType;
    private Double latitude;
    private Double longitude;
    private LocalDateTime timestamp;

    public LocationUpdatedEvent(){

    }
    public LocationUpdatedEvent(UUID entityId,EntityType entityType,Double longitude,Double latitude,LocalDateTime timestamp){
        this.entityId=entityId;
        this.entityType=entityType;
        this.latitude=latitude;
        this.longitude=longitude;
        this.timestamp=timestamp;
    }
    public UUID getEntityId() {
        return entityId;
    }
    public void setEntityId(UUID entityId) {
        this.entityId = entityId;
    }
    public EntityType getEntityType() {
        return entityType;
    }
    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
}
