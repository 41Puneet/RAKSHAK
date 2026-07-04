package com.responder_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;
import com.responder_service.Enums.ResponderType;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import com.responder_service.Enums.DutyStatus;
import com.responder_service.Enums.AvailabilityStatus;


@Entity
@Table(name="responder")
public class Responder {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false)
    private UUID userId;
    private String badgeName;
    @Column(nullable=false)
    private ResponderType type;
    @Column(nullable=false)
    private AvailabilityStatus status;
    @Column(nullable=false)
    private DutyStatus dutyStatus ;
    @Column(nullable=false)
    private Double latitude;
    @Column(nullable=false)
    private Double longitude;
    @Column(nullable=false)
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public Responder(){

    }
    public Responder(UUID id,UUID userId,String badgeName,ResponderType type,AvailabilityStatus status,DutyStatus dutyStatus,Double latitude,Double longitude,boolean active,LocalDateTime createdAt,LocalDateTime updatedAt){
        this.id=id;
        this.userId=userId;
        this.type=type;
        this.badgeName=badgeName;
        this.status=status;
        this.dutyStatus=dutyStatus;
        this.latitude=latitude;
        this.longitude=longitude;
        this.active=active;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public String getBadgeName() {
        return badgeName;
    }
    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }
    public ResponderType getType() {
        return type;
    }
    public void setType(ResponderType type) {
        this.type = type;
    }
    public AvailabilityStatus getStatus() {
        return status;
    }
    public void setStatus(AvailabilityStatus status) {
        this.status = status;
    }
    public DutyStatus getDutyStatus() {
        return dutyStatus;
    }
    public void setDutyStatus(DutyStatus dutyStatus) {
        this.dutyStatus = dutyStatus;
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
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}
