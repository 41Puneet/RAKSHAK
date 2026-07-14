package com.hospital_service.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OverRouteConfig {
    
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
