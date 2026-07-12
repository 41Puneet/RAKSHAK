package com.tracking_service.Controller;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tracking_service.DTO.Response.LocationResponse;
import com.tracking_service.Service.TrackingService;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    private final TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping("/current/{entityId}")
    public ResponseEntity<LocationResponse> getCurrentLocation(
@PathVariable UUID entityId) {

        LocationResponse response =
                trackingService.getCurrentLocation(entityId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/history/{entityId}")
    public ResponseEntity<Page<LocationResponse>> getLocationHistory(
            @PathVariable UUID entityId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<LocationResponse> response =
                trackingService.getLocationHistory(entityId, pageable);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/history/{entityId}/between")
    public ResponseEntity<Page<LocationResponse>> getLocationHistoryBetween(

@PathVariable UUID entityId,

@RequestParam
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
LocalDateTime start,
@RequestParam
@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
LocalDateTime end,

@RequestParam(defaultValue = "0") int page,

@RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);

        Page<LocationResponse> response = trackingService.getLocationHistoryBetween(entityId,start,end,pageable);

        return ResponseEntity.ok(response);
    }

}