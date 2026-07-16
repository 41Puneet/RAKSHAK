package com.hospital_service.DTO.Request;

import com.hospital_service.DTO.Request.Properties;

public class Features {
    
    private Properties properties;

    public Features(){

    }
    public Features(Properties properties){
        this.properties=properties;
    }
    public Properties getProperties() {
        return properties;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
    
}
