package com.emergency_service.DTO.Request;

import java.util.UUID;

public class CancelEmergencyRequestDTO {
    

    private UUID emergencyId;

    public CancelEmergencyRequestDTO(){

    }
    public CancelEmergencyRequestDTO(UUID emergencyId){
        this.emergencyId=emergencyId;
    }
    public UUID getEmergencyId() {
        return emergencyId;
    }
    public void setEmergencyId(UUID emergencyId) {
        this.emergencyId = emergencyId;
    }
    
}
