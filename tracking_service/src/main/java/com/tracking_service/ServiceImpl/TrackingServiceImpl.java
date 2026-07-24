package com.tracking_service.ServiceImpl;

import java.time.LocalDateTime;
import java.util.UUID;
import com.tracking_service.exception.LocationNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tracking_service.DTO.Request.LocationUpdateRequest;
import com.tracking_service.DTO.Response.LocationResponse;
import com.tracking_service.Entity.CurrentLocation;
import com.tracking_service.Entity.LocationHistory;
import com.tracking_service.Mapper.TrackingMapper;
import com.tracking_service.RabbitMQevent.event.LocationUpdatedEvent;
import com.tracking_service.RabbitMQevent.publisher.LocationEventPublisher;
import com.tracking_service.Repository.CurrentLocationRepository;
import com.tracking_service.Repository.LocationHistoryRepository;
import com.tracking_service.Service.TrackingService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TrackingServiceImpl implements TrackingService {

    private final CurrentLocationRepository currentRepository;
    private final LocationHistoryRepository historyRepository;
    private final LocationEventPublisher locationEventPublisher;
    private final TrackingMapper mapper;

    private static final Logger logger =
            LoggerFactory.getLogger(TrackingServiceImpl.class);

    public TrackingServiceImpl(CurrentLocationRepository currentRepository,
                               LocationHistoryRepository historyRepository,
                               LocationEventPublisher locationEventPublisher,
                               TrackingMapper mapper) {

        this.currentRepository = currentRepository;
        this.historyRepository = historyRepository;
        this.locationEventPublisher = locationEventPublisher;
        this.mapper = mapper;
    }

    @Override
    public LocationResponse processLocationUpdate(LocationUpdateRequest request) {

        logger.info("Received location update for entity {}", request.getEntityId());

        CurrentLocation currentLocation =
                currentRepository.findByEntityId(request.getEntityId());

        if (currentLocation == null) {

            logger.info("Creating new location for entity {}",
                    request.getEntityId());

            currentLocation = mapper.toCurrentLocation(request);

        } else {

            logger.info("Updating location for entity {}",
                    request.getEntityId());

            currentLocation.setLatitude(request.getLatitude());
            currentLocation.setLongitude(request.getLongitude());
            currentLocation.setTimestamp(request.getTimestamp());

        }

        CurrentLocation savedCurrent =
                currentRepository.save(currentLocation);

        LocationHistory history =
                mapper.toLocationHistory(request);

        historyRepository.save(history);

        LocationUpdatedEvent event =
                mapper.toLocationUpdatedEvent(savedCurrent);

        locationEventPublisher.publishLocationUpdatedEvent(event);

        logger.info("Location updated successfully for entity {}",
                request.getEntityId());

        return mapper.toLocationResponse(savedCurrent);
    }

    @Override
    public LocationResponse getCurrentLocation(UUID entityId) {

        logger.info("Fetching current location for entity {}", entityId);

        CurrentLocation location =
                currentRepository.findByEntityId(entityId);

        if (location == null) {
            throw new LocationNotFoundException("Location not found for entity " + entityId);
        }

        return mapper.toLocationResponse(location);
    }

    @Override
    public Page<LocationResponse> getLocationHistory(UUID entityId,Pageable pageable) {

        logger.info("Fetching location history for entity {}", entityId);

        Page<LocationHistory> history =
                historyRepository.findByEntityId(entityId, pageable);

        return history.map(mapper::toLocationResponse);
    }

    @Override
    public Page<LocationResponse> getLocationHistoryBetween(UUID entityId,LocalDateTime start,LocalDateTime end,Pageable pageable) {

        logger.info("Fetching location history between {} and {} for entity {}",
                start, end, entityId);

        Page<LocationHistory> history =
                historyRepository.findByEntityIdAndTimestampBetween(
                        entityId,
                        start,
                        end,
                        pageable);

        return history.map(mapper::toLocationResponse);
    }

}
