package com.hospital_service.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hospital_service.Config.OverpassProperties;

@Component
public class OverpassClient {


    private final RestTemplate restTemplate;
    private final OverpassProperties properties;

public OverpassClient(RestTemplate restTemplate,
                      OverpassProperties properties){
    this.restTemplate = restTemplate;
    this.properties = properties;
}

    public String getNearbyHospitals(double latitude, double longitude) {

        String query = String.format("""
                [out:json];
                (
                  node["amenity"="hospital"](around:%d,%f,%f);
                  way["amenity"="hospital"](around:%d,%f,%f);
                  relation["amenity"="hospital"](around:%d,%f,%f);
                );
                out center;
                """,
                properties.getRadius(), latitude, longitude,
                properties.getRadius(), latitude, longitude,
                properties.getRadius(), latitude, longitude);

        String response = restTemplate.postForObject(
                properties.getUrl(),
                query,
                String.class
        );

      return response;
    }
}