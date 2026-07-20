package com.notification_service.event.Events;

import java.util.UUID;


public class EmergencyCreatedEvent {
    

    private UUID emergencyId;
    private UUID userId;
    private String description;
    private Double latitude;
    private Double longitude;
    private String address;

    public EmergencyCreatedEvent(){

    }
    public EmergencyCreatedEvent(UUID emergencyId,UUID userId,String description,Double latitude,Double longitude,String address){
        this.emergencyId=emergencyId;
        this.description=description;
        this.userId=userId;
        this.latitude=latitude;
        this.longitude=longitude;
        this.address=address;
    }
    public UUID getEmergencyId() {
        return emergencyId;
    }
    public void setEmergencyId(UUID emergencyId) {
        this.emergencyId = emergencyId;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
}
