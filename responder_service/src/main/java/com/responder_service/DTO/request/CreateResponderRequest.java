package com.responder_service.DTO.request;

import java.util.UUID;


import com.responder_service.Enums.ResponderType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateResponderRequest {
    
    @NotNull
    private UUID userId;
    @NotBlank
    private String badgeNumber;
    @NotNull
    private ResponderType responderType;
    
    public CreateResponderRequest(){

    }
    public CreateResponderRequest(UUID userId,String badgeNumber,ResponderType responderType){
        this.userId=userId;
        this.badgeNumber=badgeNumber;
        this.responderType=responderType;
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
    public ResponderType getResponderType() {
        return responderType;
    }
    public void setResponderType(ResponderType responderType) {
        this.responderType = responderType;
    }
    
}
