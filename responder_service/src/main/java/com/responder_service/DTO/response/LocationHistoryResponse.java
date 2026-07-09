package com.responder_service.DTO.response;

import java.time.LocalDateTime;
import java.util.UUID;

public class LocationHistoryResponse {
    
    private UUID id;
    private Double latitude;
    private Double longitude;
    private LocalDateTime timestamp;

    public LocationHistoryResponse(){

    }
    public LocationHistoryResponse(UUID id,Double latitude,Double longitude,LocalDateTime timestamp){
        this.id=id;
        this.latitude=latitude;
        this.longitude=longitude;
        this.timestamp=timestamp;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    

}
