package com.responder_service.event.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.responder_service.Enums.Assignment_Status;

public class ResponderAssignedEvent {
    
    private UUID emergencyId;
    private UUID responderId;
    private double distanceKm;
    private Assignment_Status status;
    private LocalDateTime assignedAt;
   
    public ResponderAssignedEvent(){

    }
    public ResponderAssignedEvent(UUID emergencyId,UUID responderId,double distanceKm,AssignmentStatus status,LocalDateTime assignedAt){
        this.emergencyId=emergencyId;
        this.responderId=responderId;       
        this.distanceKm=distanceKm;
        this.status=status;
        this.assignedAt=assignedAt;
    }

    public UUID getEmergencyId() {
        return emergencyId;
    }

    public void setEmergencyId(UUID emergencyId) {
        this.emergencyId = emergencyId;
    }

    public UUID getResponderId() {
        return responderId;
    }

    public void setResponderId(UUID responderId) {
        this.responderId = responderId;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public Assignment_Status getStatus() {
        return status;
    }

    public void setStatus(Assignment_Status status) {
        this.status = status;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

}
