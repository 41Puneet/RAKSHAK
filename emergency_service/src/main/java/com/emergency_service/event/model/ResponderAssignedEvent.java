package com.emergency_service.event.model;



import java.time.LocalDateTime;
import java.util.UUID;
import com.emergency_service.Enums.AssignmentStatus;
import com.emergency_service.Enums.Priority;

public class ResponderAssignedEvent {
    

    private UUID emergencyId;
    private UUID responderId;
    private double distanceKm;
    private AssignmentStatus status;
    private LocalDateTime assignedAt;
    private Priority priority;
   
    public ResponderAssignedEvent(){

    }
    public ResponderAssignedEvent(UUID emergencyId,UUID responderId,double distanceKm,AssignmentStatus status,LocalDateTime assignedAt,Priority priority){
        this.emergencyId=emergencyId;
        this.responderId=responderId;       
        this.distanceKm=distanceKm;
        this.status=status;
        this.assignedAt=assignedAt;
        this.priority=priority;
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

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
}

