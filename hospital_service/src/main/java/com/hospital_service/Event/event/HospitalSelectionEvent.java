package com.hospital_service.Event.event;

import java.util.UUID;

import org.apache.tomcat.util.http.parser.Priority;

import com.hospital_service.Enum.EmergencyType;

public class HospitalSelectionEvent {
    
  

    private UUID emergencyId;

    private UUID responderId;

    private EmergencyType emergencyType;

    private Priority priority;

    private String hospitalName;
    private String hospitalAddress;
    
    private Double latitude;
    private Double longitude;

    
    private Double distanceInKm;
    private Double etaInMinutes;
  
  public HospitalSelectionEvent(UUID emergencyId,UUID responderId,EmergencyType emergencyType,Priority priority,String hospitalName,String hospitalAddress,Double latitude,Double longitude,Double distanceInKm,Double etaInMinutes){
    this.emergencyId=emergencyId;
    this.responderId=responderId;
    this.emergencyType=emergencyType;
    this.priority=priority;
    this.hospitalAddress=hospitalAddress;
    this.hospitalName=hospitalName;
    this.latitude=latitude;
    this.longitude=longitude;
    this.distanceInKm=distanceInKm;
    this.etaInMinutes=etaInMinutes;
  }

}

