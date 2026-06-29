package com.emergency_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="EmergencyLocationHistory")
public class EmergencyLocationHistory {
    

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false)
    private UUID emergencyId;
    @Column(nullable=false)
    private Double latitude;
    @Column(nullable=false)
    private Double longitude;
    private LocalDateTime timeStamp;
    @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "emergency_id")
private EmergencyRequest emergencyRequest;

    public EmergencyLocationHistory(){

    }
    public EmergencyLocationHistory(UUID id,UUID emergencyId,Double latitude,Double longitude,LocalDateTime timestamp){
        this.id=id;
        this.emergencyId=emergencyId;
        this.latitude=latitude;
        this.longitude=longitude;
        this.timeStamp=timestamp;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getEmergencyId() {
        return emergencyId;
    }
    public void setEmergencyId(UUID emergencyId) {
        this.emergencyId = emergencyId;
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
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    
}
