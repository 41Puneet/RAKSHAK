package com.responder_service.DTO.response;

import java.util.UUID;

import com.responder_service.Enums.ResponderType;

public class ResponderResponse {
    
    private UUID id;
    private UUID userId;
    private String badgeNumber;
    private ResponderType type;
    private Double latitude;
    private Double longitude;
    
    public ResponderResponse(){

    }
    public ResponderResponse(UUID id ,UUID userId,String badgeNumber,ResponderType type,Double latitude,Double longitude){
        this.id=id;
        this.userId=userId;
        this.badgeNumber=badgeNumber;
        this.type=type;
        this.latitude=latitude;
        this.longitude=longitude;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public String getBadgeNumber() {
        return badgeNumber;
    }
    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }
    public ResponderType getType() {
        return type;
    }
    public void setType(ResponderType type) {
        this.type = type;
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
    
}
