package com.hospital_service.DTO.Response;

import com.hospital_service.DTO.Response.Tags;

public class Element {
    

    private String type;
    private Long id;
    private Double lat;
    private Double lon;
    private Tags tags;
    public Element(){

    }
    public Element(String type,Long id,Double lat,Double lon,Tags tags){
        this.type=type;
        this.id=id;
        this.lat=lat;
        this.lon=lon;
        this.tags=tags;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getLat() {
        return lat;
    }
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLon() {
        return lon;
    }
    public void setLon(Double lon) {
        this.lon = lon;
    }
    public Tags getTags() {
        return tags;
    }
    public void setTags(Tags tags) {
        this.tags = tags;
    }
    
}
