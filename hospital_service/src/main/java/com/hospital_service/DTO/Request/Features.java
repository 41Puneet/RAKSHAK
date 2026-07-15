package com.hospital_service.DTO.Request;

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
