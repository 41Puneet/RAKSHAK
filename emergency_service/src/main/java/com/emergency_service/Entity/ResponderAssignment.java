package com.emergency_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.emergency_service.Enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="responderDetails")
public class ResponderAssignment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false)
    private UUID responderId;
    private LocalDateTime assignedAt;
    private LocalDateTime acceptedAt;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "emergency_id")
private EmergencyRequest emergencyRequest;


    public ResponderAssignment(){

    }
    public ResponderAssignment(UUID id,UUID responderId,LocalDateTime assignedAt,LocalDateTime acceptedAt,Status status){
        this.id=id;
        
        this.responderId=responderId;
        this.assignedAt=assignedAt;
        this.acceptedAt=acceptedAt;
        this.status=status;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
   
    public UUID getResponderId() {
        return responderId;
    }
    public void setResponderId(UUID responderId) {
        this.responderId = responderId;
    }
    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }
    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }
    public LocalDateTime getAcceptedAt() {
        return acceptedAt;
    }
    public void setAcceptedAt(LocalDateTime acceptedAt) {
        this.acceptedAt = acceptedAt;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    
}
