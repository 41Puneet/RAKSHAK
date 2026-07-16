package com.hospital_service.DTO.Response;

import com.hospital_service.DTO.Response.Properties;

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
