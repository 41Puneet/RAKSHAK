package com.hospital_service.Client;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenRouteClient {

    private final RestTemplate restTemplate;

    @Value("${openroute.api-key}")
    private String apiKey;

    @Value("${openroute.url}")
    private String openRouteUrl;

    public OpenRouteClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getRoute(double sourceLat,
                           double sourceLon,
                           double destinationLat,
                           double destinationLon) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", apiKey);

        Map<String, Object> body = Map.of(
                "coordinates",
                new double[][]{
                        {sourceLon, sourceLat},
                        {destinationLon, destinationLat}
                });

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(body, headers);

        return restTemplate.postForObject(
                openRouteUrl,
                entity,
                String.class
        );
    }
}