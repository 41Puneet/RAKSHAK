package com.tracking_service.DTO.Request;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.tracking_service.Enum.EntityType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;



public class LocationUpdateRequest {

    @NotNull(message = "Entity ID is required")
    private UUID entityId;

    @NotNull(message = "Entity type is required")
    private EntityType entityType;

    @NotNull(message = "Latitude is required")
    @DecimalMin(value = "-90.0")
    @DecimalMax(value = "90.0")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0")
    @DecimalMax(value = "180.0")
    private Double longitude;

    @NotNull(message = "Timestamp is required")
    private LocalDateTime timestamp;

    public LocationUpdateRequest(){

    }
    public LocationUpdateRequest(UUID entityId,EntityType entityType,Double latitude,Double longitude,LocalDateTime timestamp){
    
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
