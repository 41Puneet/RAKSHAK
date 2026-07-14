package com.responder_service.DTO.response;

import java.util.UUID;

import com.responder_service.Enums.Priority;

public class PriorityResponse {
    

    private UUID emergencyId;
    private UUID responderId;
    private Priority priority;

    public PriorityResponse(){

    }
    public PriorityResponse(UUID emergencyId,UUID responderId,Priority priority){
        this.emergencyId=emergencyId;
        this.responderId=responderId;
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
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
}
