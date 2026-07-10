package com.responder_service.DTO.request;

import com.responder_service.Entity.ResponderVehicle;

public class UpdateResponder {
    
    private String badgeNumber;
    private ResponderVehicle responderVehicle;

    public UpdateResponder(){

    }
    public UpdateResponder(String badgeNumber,ResponderVehicle responderVehicle){
        this.badgeNumber=badgeNumber;
        this.responderVehicle=responderVehicle;
    }
    public String getBadgeNumber() {
        return badgeNumber;
    }
    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }
    public ResponderVehicle getResponderVehicle() {
        return responderVehicle;
    }
    public void setResponderVehicle(ResponderVehicle responderVehicle) {
        this.responderVehicle = responderVehicle;
    }
    
}
