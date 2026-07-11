package com.tracking_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.tracking_service.Enum.EntityType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="current_location")
public class CurrentLocation {
    

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false,unique=true)
    private UUID entityId;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private EntityType entityType;
    @Column(nullable=false)
    private Double latitude;
    @Column(nullable=false)
    private Double longitude;
    private Double altitude;
    private Float speed;
    private Float heading;
    private Float accuracy;
    @Column(nullable=false)
    private LocalDateTime timestamp;

    public CurrentLocation(){

    }
    public CurrentLocation(UUID id,UUID entityId,EntityType entityType,Double latitude,Double longitude,Double altitude,Float speed,Float heading,Float accuracy,LocalDateTime timestamp){
        this.id=id;
        this.entityId=entityId;
        this.entityType=entityType;
        this.latitude=latitude;
        this.longitude=longitude;
        this.altitude=altitude;
        this.speed=speed;
        this.heading=heading;
        this.accuracy=accuracy;
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
    public Double getAltitude() {
        return altitude;
    }
    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }
    public Float getSpeed() {
        return speed;
    }
    public void setSpeed(Float speed) {
        this.speed = speed;
    }
    public Float getHeading() {
        return heading;
    }
    public void setHeading(Float heading) {
        this.heading = heading;
    }
    public Float getAccuracy() {
        return accuracy;
    }
    public void setAccuracy(Float accuracy) {
        this.accuracy = accuracy;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
}
