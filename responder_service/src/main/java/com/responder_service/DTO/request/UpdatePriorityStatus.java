package com.responder_service.DTO.request;

import java.util.UUID;

import com.responder_service.Enums.Priority;

import jakarta.validation.constraints.NotNull;

public class UpdatePriorityStatus {
    

    @NotNull
    private UUID emergencyId;
    @NotNull
    private Priority priority;

    public UpdatePriorityStatus(){

    }
    public UpdatePriorityStatus(UUID emergencyId,Priority priority){
        this.emergencyId=emergencyId;
        this.priority=priority;
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
    
}
