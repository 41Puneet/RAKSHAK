package com.responder_service.DTO.request;

import java.time.LocalDateTime;
import java.util.UUID;

import com.responder_service.Enums.Assignment_Status;

import jakarta.validation.constraints.NotNull;

public class CompleteAssignmentRequest {

    @NotNull
    private UUID id;
    @NotNull
    private Assignment_Status status;
    @NotNull
    private LocalDateTime assignedAt;
    @NotNull
    private LocalDateTime acceptedAt;
    @NotNull
    private LocalDateTime reachedAt;
    @NotNull
    private LocalDateTime completedAt;

    public CompleteAssignmentRequest(){

    }
    public CompleteAssignmentRequest(UUID id,Assignment_Status status,LocalDateTime assignedAt,LocalDateTime acceptedAt,LocalDateTime reachedAt,LocalDateTime completedAt){
        this.id=id;
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
