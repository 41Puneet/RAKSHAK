package com.emergency_service.DTO.Response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.emergency_service.Enums.EmergencyType;
import com.emergency_service.Enums.Priority;
import com.emergency_service.Enums.Status;

public class EmergencyResponseDTO {
    private UUID emergencyId;
    private UUID userId;
    private EmergencyType emergencyType;
    private Status status;
    private Double latitude;
    private Double longitude;
    private String address;
    private UUID responderId;
    private UUID hospitalId;
    private Priority priority;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;
    

    public EmergencyResponseDTO(){

    }
    public EmergencyResponseDTO(UUID emergencyId,UUID userId,EmergencyType emergencyType,Status status,Double latitude,Double longitude,String address,UUID responderId,UUID hospitalId,Priority priority,String description,LocalDateTime createdAt,LocalDateTime updatedAt,Boolean active){
    this.emergencyId=emergencyId;
    this.userId=userId;
    this.emergencyType=emergencyType;
    this.status=status;
    this.latitude=latitude;
    this.longitude=longitude;
    this.address=address;
    this.responderId=responderId;
    this.hospitalId=hospitalId;
    this.priority=priority;
    this.description=description;
    this.createdAt=createdAt;
    this.updatedAt=updatedAt;
    this.active=active;
    }
    public UUID getEmergencyId() {
        return emergencyId;
    }
    public void setEmergencyId(UUID emergencyId) {
        this.emergencyId = emergencyId;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public EmergencyType getEmergencyType() {
        return emergencyType;
    }
    public void setEmergencyType(EmergencyType emergencyType) {
        this.emergencyType = emergencyType;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public UUID getResponderId() {
        return responderId;
    }
    public void setResponderId(UUID responderId) {
        this.responderId = responderId;
    }
    public UUID getHospitalId() {
        return hospitalId;
    }
    public void setHospitalId(UUID hospitalId) {
        this.hospitalId = hospitalId;
    }
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }


}
