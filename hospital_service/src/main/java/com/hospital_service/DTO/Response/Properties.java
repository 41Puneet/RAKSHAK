package com.hospital_service.DTO.Response;
import java.util.List;

public class Properties {

    private List<Segment> segments;

    public Properties(){

    }
    public Properties(List<Segment>segments){
        this.segments=segments;
    }

    public List<Segment> getSegments() {
        return segments;
    }

    public void setSegments(List<Segment> segments) {
        this.segments = segments;
    }
}