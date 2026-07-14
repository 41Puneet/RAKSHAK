package com.responder_service.DTO.request;

import java.util.UUID;

import com.responder_service.Enums.EmergencyType;
import com.responder_service.Enums.Priority;

import jakarta.validation.constraints.NotNull;

public class UpdatePriorityStatus {
    

    @NotNull
    private UUID emergencyId;
    @NotNull
    private UUID responderId;
    @NotNull
    private Double longitude;
    @NotNull
    private Double latitude;
    @NotNull
    private EmergencyType emergencyType;
    @NotNull
    private Priority priority;

    public UpdatePriorityStatus(){

    }
    public UpdatePriorityStatus(UUID emergencyId,Priority priority,UUID responderId,Double latitude,Double longitude,EmergencyType emergencyType){
        this.emergencyId=emergencyId;
        this.priority=priority;
        this.latitude=latitude;
        this.longitude=longitude;
        this.emergencyType=emergencyType;
    }
    public UUID getEmergencyId() {
        return emergencyId;
    }
    public void setEmergencyId(UUID emergencyId) {
        this.emergencyId = emergencyId;
    }
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public UUID getResponderId() {
        return responderId;
    }
    public void setResponderId(UUID responderId) {
        this.responderId = responderId;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public EmergencyType getEmergencyType() {
        return emergencyType;
    }
    public void setEmergencyType(EmergencyType emergencyType) {
        this.emergencyType = emergencyType;
    }
    
}
