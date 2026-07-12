package com.tracking_service.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;


import com.tracking_service.DTO.Request.LocationUpdateRequest;
import com.tracking_service.Service.TrackingService;

@Controller
public class TrackingWebSocketController {

    private final TrackingService trackingService;

    public TrackingWebSocketController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @MessageMapping("/location/update")
    public void updateLocation(@Payload LocationUpdateRequest request) {

        trackingService.processLocationUpdate(request);

    }

}