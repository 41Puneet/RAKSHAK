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

  public UUID getEmergencyId() {
    return emergencyId;
  }

  public void setEmergencyId(UUID emergencyId) {
    this.emergencyId = emergencyId;
  }

  public UUID getResponderId() {
    return responderId;
  }

  public void setResponderId(UUID responderId) {
    this.responderId = responderId;
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

  public String getHospitalName() {
    return hospitalName;
  }

  public void setHospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public String getHospitalAddress() {
    return hospitalAddress;
  }

  public void setHospitalAddress(String hospitalAddress) {
    this.hospitalAddress = hospitalAddress;
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

  public Double getDistanceInKm() {
    return distanceInKm;
  }

  public void setDistanceInKm(Double distanceInKm) {
    this.distanceInKm = distanceInKm;
  }

  public Double getEtaInMinutes() {
    return etaInMinutes;
  }

  public void setEtaInMinutes(Double etaInMinutes) {
    this.etaInMinutes = etaInMinutes;
  }

}

