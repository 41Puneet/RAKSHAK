package com.hospital_service.DTO.Response;

import java.util.List;

public class RouteResponse {
    
    private List<Features>features;

    public RouteResponse(){

    }
    public RouteResponse(List<Features>features){
        this.features=features;
    }
    public List<Features> getFeatures() {
        return features;
    }
    public void setFeatures(List<Features> features) {
        this.features = features;
    }
    
}
