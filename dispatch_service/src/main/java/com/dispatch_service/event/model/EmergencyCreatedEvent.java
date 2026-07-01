package com.dispatch_service.event.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.dispatch_service.Enums.EmergencyType;
import com.dispatch_service.Enums.Priority;

public class EmergencyCreatedEvent {
private UUID emergencyId;

private UUID userId;

private EmergencyType emergencyType;

private Double latitude;

private Double longitude;

private Priority priority;

private LocalDateTime createdAt;

public EmergencyCreatedEvent(){

}
public EmergencyCreatedEvent(UUID emergencyId,UUID userId,EmergencyType emergencyType,Double latitude,Double longitude,Priority priority,LocalDateTime createdAt){
    this.emergencyId=emergencyId;
    this.userId=userId;
    this.emergencyType=emergencyType;
    this.latitude=latitude;
    this.longitude=longitude;
    this.priority=priority;
    this.createdAt=createdAt;
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
public Priority getPriority() {
    return priority;
}
public void setPriority(Priority priority) {
    this.priority = priority;
}
public LocalDateTime getCreatedAt() {
    return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}


}
