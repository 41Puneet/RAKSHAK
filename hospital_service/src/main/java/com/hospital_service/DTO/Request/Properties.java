package com.hospital_service.DTO.Request;

import com.hospital_service.DTO.Request.Summary;

public class Properties {
    
    private Summary summary;

    public Properties(){

    }
    public Properties(Summary summary){
        this.summary=summary;
    }
    public Summary getSummary() {
        return summary;
    }
    public void setSummary(Summary summary) {
        this.summary = summary;
    }
    
}
