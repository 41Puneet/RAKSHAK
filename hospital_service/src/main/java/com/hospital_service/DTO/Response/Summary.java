package com.hospital_service.DTO.Response;

public class Summary {
    
    private Double distance;
    private Double duration;

    public Summary(){

    }
    public Summary(Double distance,Double duration){
        this.distance=distance;
        this.duration=duration;
    }
    public Double getDistance() {
        return distance;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    public Double getDuration() {
        return duration;
    }
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    
}
