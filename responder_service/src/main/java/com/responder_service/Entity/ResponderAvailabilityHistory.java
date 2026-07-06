package com.responder_service.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.responder_service.Enums.AvailabilityStatus;

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
@Table(name="responder_availability_history")
public class ResponderAvailabilityHistory {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus previousStatus;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private AvailabilityStatus newStatus;
    @Column(nullable=false)
    private LocalDateTime changedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="responder_id")
    private Responder responder;

    public ResponderAvailabilityHistory(){
        
    }
    public ResponderAvailabilityHistory(UUID id,AvailabilityStatus previousStatus,AvailabilityStatus newStatus,LocalDateTime changedAt,Responder responder){
     
        this.id=id;
        this.previousStatus=previousStatus;
        this.newStatus=newStatus;
        this.changedAt=changedAt;
        this.responder=responder;
    }
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public AvailabilityStatus getPreviousStatus() {
        return previousStatus;
    }
    public void setPreviousStatus(AvailabilityStatus previousStatus) {
        this.previousStatus = previousStatus;
    }
    public AvailabilityStatus getNewStatus() {
        return newStatus;
    }
    public void setNewStatus(AvailabilityStatus newStatus) {
        this.newStatus = newStatus;
    }
    public LocalDateTime getChangedAt() {
        return changedAt;
    }
    public void setChangedAt(LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }
    public Responder getResponder() {
        return responder;
    }
    public void setResponder(Responder responder) {
        this.responder = responder;
    }
    
}
