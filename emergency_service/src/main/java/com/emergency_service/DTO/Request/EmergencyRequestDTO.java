package com.emergency_service.DTO.Request;

import com.emergency_service.Enums.EmergencyType;
import com.emergency_service.Enums.Priority;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class EmergencyRequestDTO {
    

    @NotNull
    private EmergencyType emergencyType;
    @NotNull
    @DecimalMin(value = "-90.0")
    @DecimalMax(value = "90.0") 
    private Double latitude;
    @NotNull
    @DecimalMin(value="-180.0")
    @DecimalMax(value="180.0")
    private Double longitude;
    private String description;
    
    private String address;
    @NotNull
    private Priority priority;

    public EmergencyRequestDTO(){

    }
    public EmergencyRequestDTO(EmergencyType emergencyType,Double latitude,Double longitude,String description,String address,Priority priority){
        this.emergencyType=emergencyType;
        this.latitude=latitude;
        this.longitude=longitude;
        this.description=description;
        this.address=address;
        this.priority=priority;
    }
    public EmergencyType getEmergencyType() {
        return emergencyType;
    }
    public void setEmergencyType(EmergencyType emergencyType) {
        this.emergencyType = emergencyType;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
}
