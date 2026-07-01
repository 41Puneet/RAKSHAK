package com.dispatch_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.dispatch_service.Enums.AssignmentStatus;
import com.dispatch_service.Enums.Priority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


@Entity
@Table(
    name = "dispatch_assignment",
    indexes = {
        @Index(name = "idx_emergency", columnList = "emergencyId"),
        @Index(name = "idx_responder", columnList = "responderId")
    }
)
public class DispatchAssignment {
    


    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false)
    private UUID emergencyId;
    @Column(nullable=false)
    private UUID responderId;
    private Double distanceKm;
    @Enumerated(EnumType.STRING)
    private AssignmentStatus status = AssignmentStatus.ASSIGNED;
    private LocalDateTime assignedAt;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    public DispatchAssignment(){

    }
    public DispatchAssignment(UUID id,UUID emergencyId,UUID responderId,Double distanceKm,AssignmentStatus status,LocalDateTime assignedAt,Priority priority){
        this.id=id;
        this.emergencyId=emergencyId;
        this.responderId=responderId;
        this.distanceKm=distanceKm;
        this.status=status;
        this.assignedAt=assignedAt;
        this.priority=priority;
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
    public UUID getResponderId() {
        return responderId;
    }
    public void setResponderId(UUID responderId) {
        this.responderId = responderId;
    }
    public Double getDistanceKm() {
        return distanceKm;
    }
    public void setDistanceKm(Double distanceKm) {
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
    
    @PrePersist
public void prePersist() {
    this.assignedAt = LocalDateTime.now();
}
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
}
