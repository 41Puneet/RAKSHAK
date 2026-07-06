package com.responder_service.DTO.request;

import com.responder_service.Enums.ResponderType;

public class UpdateResponderRequest {
    
    private String badgeNumber;
    private ResponderType type;

    public UpdateResponderRequest(){

    }
    public UpdateResponderRequest(String badgeNumber,ResponderType type){
        this.badgeNumber=badgeNumber;
        this.type=type;
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
    
}
