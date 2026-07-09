package com.responder_service.DTO.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.responder_service.Enums.AvailabilityStatus;

public class AvailabilityHistoryResponse {
    
    private UUID id;
    private AvailabilityStatus previousStatus;
    private AvailabilityStatus newStatus;
    private LocalDateTime changedAt;

    public AvailabilityHistoryResponse(){

    }
    public AvailabilityHistoryResponse(UUID id,AvailabilityStatus previousStatus,AvailabilityStatus newStatus,LocalDateTime changedAt){
        this.id=id;
        this.previousStatus=previousStatus;
        this.newStatus=newStatus;
        this.changedAt=changedAt;
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
    
}
