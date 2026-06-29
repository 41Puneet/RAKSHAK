package com.emergency_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;
import com.emergency_service.Enums.EmergencyType;
import com.emergency_service.Enums.Status;
import com.emergency_service.Enums.Priority;

public class EmergencyRequest {
    private UUID userId;
    private EmergencyType emergencyType;
    private String description;
    private Status status;
    private Double latitude;
    private Double longitude;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID responderId;
    private UUID hospitalId;
    private Priority priority;
    private boolean isActive;


    public EmergencyRequest(){

    }
    public EmergencyRequest(UUID userId,EmergencyType emergencyType,String description,Status status,Double latitude,Double longitude,String address,LocalDateTime createdAt,LocalDateTime updatedAt,UUID responderId,UUID hospitalId,Priority priority,boolean isActive){
     
        this.userId=userId;
        this.emergencyType=emergencyType;
        this.description=description;
        this.status=status;
        this.latitude=latitude;
        this.longitude=longitude;
        this.address=address;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
        this.responderId=responderId;
        this.priority=priority;
        this.isActive=isActive;
    }

}
