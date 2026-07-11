package com.tracking_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.type.EntityType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="location_history")
public class LocationHistory {
    

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false,unique=true)
    private UUID entityId;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private EntityType entityType;
    @Column(nullable=false)
    private Double latitude;
    @Column(nullable=false)
    private Double longitude;
    @Column(nullable=false)
    private LocalDateTime timestamp;



    public LocationHistory(){

    }
    public LocationHistory(UUID id,UUID entityId,EntityType entityType,Double latitude,Double longitude,LocalDateTime timestamp){
        this.id=id;
        this.entityId=entityId;
        this.entityType=entityType;
        this.latitude=latitude;
        this.longitude=longitude;
        this.timestamp=timestamp;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
