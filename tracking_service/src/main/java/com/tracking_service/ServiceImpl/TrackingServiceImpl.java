package com.tracking_service.ServiceImpl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.tracking_service.DTO.Request.LocationUpdateRequest;
import com.tracking_service.DTO.Response.LocationResponse;
import com.tracking_service.Entity.CurrentLocation;
import com.tracking_service.Entity.LocationHistory;
import com.tracking_service.Mapper.TrackingMapper;
import com.tracking_service.RabbitMQevent.publisher.LocationEventPublisher;
import com.tracking_service.Repository.CurrentLocationRepository;
import com.tracking_service.Repository.LocationHistoryRepository;
import com.tracking_service.Service.TrackingService;

public class TrackingServiceImpl implements TrackingService {

    private final CurrentLocationRepository currentRepository;
    private final LocationHistoryRepository historyRepository;
    private final LocationEventPublisher locationEventPublisher;
    private final TrackingMapper mapper;
    private static final Logger logger=LoggerFactory.getLogger(TrackingServiceImpl.class);

    public TrackingServiceImpl(CurrentLocationRepository currentRepository,LocationHistoryRepository historyRepository,LocationEventPublisher locationEventPublisher,TrackingMapper mapper){
        this.currentRepository=currentRepository;
        this.historyRepository=historyRepository;
        this.locationEventPublisher=locationEventPublisher;
        this.mapper=mapper;
    }

    @Override
    public LocationResponse getCurrentLocation(UUID entityId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<LocationResponse> getLocationHistory(UUID entityId, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<LocationResponse> getLocationHistoryBetween(UUID entityId, LocalDateTime start, LocalDateTime end,
            Pageable pageable) {
        Page<com.tracking_service.Entity.LocationHistory> historyPage = historyRepository.findByEntityIdAndTimestampBetween(entityId, start, end, pageable);
        return historyPage.map(mapper::toLocationResponse);
    }

    @Override
    public LocationResponse processLocationUpdate(LocationUpdateRequest request) {

       CurrentLocation currentLocation = currentRepository.findByEntityId(request.getEntityId());
       if (currentLocation != null) {
           currentLocation.setLatitude(request.getLatitude());
           currentLocation.setLongitude(request.getLongitude());
           currentLocation.setTimestamp(request.getTimestamp());
       }

       // map request to entities
       CurrentLocation location = mapper.toCurrentLocation(request);
       LocationHistory history = mapper.toLocationHistory(request);

       locationEventPublisher.publishLocationUpdatedEvent(request);

       // save current location (update or insert)
       CurrentLocation savedCurrent = currentRepository.save(location);

       // save history
       historyRepository.save(history);

       // publish event converted to the expected event type


       // return response
       return mapper.toLocationResponse(savedCurrent);
    }
    
}
