package com.hospital_service.DTO.Request;

import com.hospital_service.Enum.EmergencyType;
import com.hospital_service.Enum.Priority;

public class HospitalSearchRequest {
    
    private Double latitude;
    private Double longitude;
    private EmergencyType emergencyType;
    private Priority priority;

    public HospitalSearchRequest(){

    }
     public HospitalSearchRequest(Double latitude,Double longitude,EmergencyType emergencyType,Priority priority){
        this.latitude=latitude;
        this.longitude=longitude;
        this.emergencyType=emergencyType;
        this.priority=priority;
    }
     public Double getLatitude() {
         return latitude;
     }
     public void setLatitude(Double latitude) {
         this.latitude = latitude;
     }
     public Double getLongitude() {
         return longitude;
     }
     public void setLongitude(Double longitude) {
         this.longitude = longitude;
     }
     public EmergencyType getEmergencyType() {
         return emergencyType;
     }
     public void setEmergencyType(EmergencyType emergencyType) {
         this.emergencyType = emergencyType;
     }
     public Priority getPriority() {
         return priority;
     }
     public void setPriority(Priority priority) {
         this.priority = priority;
     }
    
}
