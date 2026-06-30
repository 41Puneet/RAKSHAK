package com.dispatch_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="dispatch_log")
public class DispatchLog {
    
@Id
@GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    private UUID emergencyId;
    private String message;
    private LocalDateTime timestamp;

    public DispatchLog(){

    }
    public DispatchLog(UUID id,UUID emergencyId,String message,LocalDateTime timestamp){
        this.id=id;
        this.emergencyId=emergencyId;
        this.message=message;
        this.timestamp=timestamp;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getEmergencyId() {
        return emergencyId;
    }
    public void setEmergencyId(UUID emergencyId) {
        this.emergencyId = emergencyId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
}

