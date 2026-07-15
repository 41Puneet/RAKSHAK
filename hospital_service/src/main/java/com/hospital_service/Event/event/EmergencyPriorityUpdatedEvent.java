package com.hospital_service.Event.event;
import java.util.UUID;

import com.hospital_service.Enum.EmergencyType;
import com.hospital_service.Enum.Priority;

public class EmergencyPriorityUpdatedEvent {

    private UUID emergencyId;
    private UUID responderId;
    private Double latitude;
    private Double longitude;
    private EmergencyType emergencyType;
    private Priority priority;

    public EmergencyPriorityUpdatedEvent(){

    }
    public EmergencyPriorityUpdatedEvent(UUID emergencyId,UUID responderId,Double latitude,Double longitude,EmergencyType emergencyType,Priority priority){
        this.emergencyId=emergencyId;
        this.responderId=responderId;
        this.latitude=latitude;
        this.longitude=longitude;
        this.emergencyType=emergencyType;
        this.priority=priority;
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
