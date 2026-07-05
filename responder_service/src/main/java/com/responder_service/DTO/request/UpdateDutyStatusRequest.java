package com.responder_service.DTO.request;

import java.util.UUID;

import com.responder_service.Enums.DutyStatus;

import jakarta.validation.constraints.NotNull;

public class UpdateDutyStatusRequest {
    
    @NotNull
    private UUID id;
    @NotNull
    private DutyStatus dutyStatus;

    public UpdateDutyStatusRequest(){

    }
    public UpdateDutyStatusRequest(UUID id,DutyStatus dutyStatus){
        this.id=id;
        this.dutyStatus=dutyStatus;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public DutyStatus getDutyStatus() {
        return dutyStatus;
    }
    public void setDutyStatus(DutyStatus dutyStatus) {
        this.dutyStatus = dutyStatus;
    }

}
