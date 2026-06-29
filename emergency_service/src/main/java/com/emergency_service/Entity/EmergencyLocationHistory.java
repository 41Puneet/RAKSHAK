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
    private Double latitude;
    @Column(nullable=false)
    private Double longitude;
    private LocalDateTime recorderAt;
    @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "emergency_id",nullable=false)
private EmergencyRequest emergencyRequest;

    public EmergencyLocationHistory(){

    }
    public EmergencyLocationHistory(UUID id,Double latitude,Double longitude,LocalDateTime recorderAt,EmergencyRequest emergencyRequest){
        this.id=id;
        this.latitude=latitude;
        this.longitude=longitude;
        this.recorderAt=recorderAt;
        this.emergencyRequest=emergencyRequest;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Double getLatitude() {
        return latitude;
    }
    public EmergencyRequest getEmergencyRequest() {
        return emergencyRequest;
    }
    public void setEmergencyRequest(EmergencyRequest emergencyRequest) {
        this.emergencyRequest = emergencyRequest;
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
    public LocalDateTime getRecorderAt() {
        return recorderAt;
    }
    public void setRecorderAt(LocalDateTime recorderAt) {
        this.recorderAt = recorderAt;
    }
    
}
