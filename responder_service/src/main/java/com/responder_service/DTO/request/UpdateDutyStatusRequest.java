package com.responder_service.DTO.request;

import java.util.UUID;

import com.responder_service.Enums.DutyStatus;

import jakarta.validation.constraints.NotNull;

public class UpdateDutyStatusRequest {
    
    @NotNull
    private DutyStatus dutyStatus;

    public UpdateDutyStatusRequest(){

    }
    public UpdateDutyStatusRequest(DutyStatus dutyStatus){
     
        this.dutyStatus=dutyStatus;
    }
    public DutyStatus getDutyStatus() {
        return dutyStatus;
    }
    public void setDutyStatus(DutyStatus dutyStatus) {
        this.dutyStatus = dutyStatus;
    }

}
