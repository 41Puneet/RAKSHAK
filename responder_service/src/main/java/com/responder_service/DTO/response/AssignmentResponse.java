package com.responder_service.DTO.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.responder_service.DTO.request.AssignResponderRequest;
import com.responder_service.Enums.Assignment_Status;


public class AssignmentResponse {
    
    private UUID id;
    private UUID emergencyId;
    private Assignment_Status status;
    private LocalDateTime assignedAt;
    private LocalDateTime acceptedAt;
    private LocalDateTime reachedAt;
    private LocalDateTime completedAt;
    private ResponderResponse response;
    public AssignmentResponse(){

    }
    public AssignmentResponse(ResponderResponse response,UUID id,UUID emergencyId,Assignment_Status status,LocalDateTime assignedAt,LocalDateTime acceptedAt,LocalDateTime reachedAt,LocalDateTime completedAt){
        this.response=response;
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
    public ResponderResponse getResponse() {
        return response;
    }
    public void setResponse(ResponderResponse response) {
        this.response = response;
    }
   
    
}
