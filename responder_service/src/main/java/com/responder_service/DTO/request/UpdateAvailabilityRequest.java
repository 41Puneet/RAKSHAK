package com.responder_service.DTO.request;

import java.util.UUID;

import com.responder_service.Enums.AvailabilityStatus;

import jakarta.validation.constraints.NotNull;

public class UpdateAvailabilityRequest {
    @NotNull
    private AvailabilityStatus newStatus;

    public UpdateAvailabilityRequest(){

    }
    public UpdateAvailabilityRequest(AvailabilityStatus newStatus){
      
        this.newStatus=newStatus;
    }
    public AvailabilityStatus getNewStatus() {
        return newStatus;
    }
    public void setNewStatus(AvailabilityStatus newStatus) {
        this.newStatus = newStatus;
    }

}
