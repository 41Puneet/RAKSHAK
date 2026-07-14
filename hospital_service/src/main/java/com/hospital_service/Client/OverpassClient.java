package com.hospital_service.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OverpassClient {

    private final RestTemplate restTemplate;

    @Value("${overpass.url}")
    private String overpassUrl;

    @Value("${overpass.radius}")
    private Integer radius;

    public OverpassClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void getNearbyHospitals(double latitude, double longitude) {

        String query = String.format("""
                [out:json];
                (
                  node["amenity"="hospital"](around:%d,%f,%f);
                  way["amenity"="hospital"](around:%d,%f,%f);
                  relation["amenity"="hospital"](around:%d,%f,%f);
                );
                out center;
                """,
                radius, latitude, longitude,
                radius, latitude, longitude,
                radius, latitude, longitude);

        String response = restTemplate.postForObject(
                overpassUrl,
                query,
                String.class
        );

        System.out.println(response);
    }
}