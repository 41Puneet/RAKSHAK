package com.tracking_service.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tracking_service.DTO.Request.LocationUpdateRequest;
import com.tracking_service.DTO.Response.LocationResponse;

public interface TrackingService {

    LocationResponse processLocationUpdate(LocationUpdateRequest request);

    LocationResponse getCurrentLocation(UUID entityId);

    Page<LocationResponse> getLocationHistory(UUID entityId,Pageable pageable);

    Page<LocationResponse> getLocationHistoryBetween(UUID entityId,LocalDateTime start,LocalDateTime end,Pageable pageable);

}