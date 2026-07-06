package com.responder_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.responder_service.Enums.Assignment_Status;

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
@Table(name="responder_assignment")
public class ResponderAssignment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false)
    private UUID emergencyId;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Assignment_Status status;
    @Column(nullable=false)
    private LocalDateTime assignedAt;
    @Column(nullable=false)
    private LocalDateTime acceptedAt;
    @Column(nullable=false)
    private LocalDateTime reachedAt;
    @Column(nullable=false)
    private LocalDateTime completedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responder_id")
    private Responder responder;
    
    public ResponderAssignment(){

    }
    public Responder getResponder() {
        return responder;
    }
    public void setResponder(Responder responder) {
        this.responder = responder;
    }
    public ResponderAssignment(Responder responder,UUID id,UUID emergencyId,Assignment_Status status,LocalDateTime assignedAt,LocalDateTime acceptedAt,LocalDateTime reachedAt,LocalDateTime completedAt){
        this.responder=responder;
        this.id=id;
        this.emergencyId=emergencyId;
        this.status=status;
        this.assignedAt=assignedAt;
        this.acceptedAt=acceptedAt;
        this.reachedAt=reachedAt;
        this.completedAt=completedAt;
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
    public LocalDateTime getAcceptedAt() {
        return acceptedAt;
    }
    public void setAcceptedAt(LocalDateTime acceptedAt) {
        this.acceptedAt = acceptedAt;
    }
    public LocalDateTime getReachedAt() {
        return reachedAt;
    }
    public void setReachedAt(LocalDateTime reachedAt) {
        this.reachedAt = reachedAt;
    }
    public LocalDateTime getCompletedAt() {
        return completedAt;
    }
    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
    
}

