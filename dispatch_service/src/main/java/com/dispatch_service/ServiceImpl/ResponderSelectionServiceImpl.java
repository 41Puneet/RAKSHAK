package com.dispatch_service.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dispatch_service.Entity.ResponderLocation;
import com.dispatch_service.Repository.ResponderLocationRepository;
import com.dispatch_service.Service.GeoService;
import com.dispatch_service.Service.ResponderSelectionService;


@Service
public class ResponderSelectionServiceImpl implements ResponderSelectionService {
    private static final Logger log=LoggerFactory.getLogger(ResponderSelectionServiceImpl.class);
    private static final double SEARCH_RADIUS_KM=25.0;
    private static final double KM_PER_DEGREE=111.0;
    private final GeoService geoService;
    private final ResponderLocationRepository responderLocationRepository;

    public ResponderSelectionServiceImpl(GeoService geoService, ResponderLocationRepository responderLocationRepository) {
        this.geoService = geoService;
        this.responderLocationRepository = responderLocationRepository;
    }

    @Override
public ResponderLocation findNearestAvailableResponder(Double latitude, Double longitude) {

    log.debug("Selecting responder for emergency location {},{}", latitude, longitude);

    double latDelta = SEARCH_RADIUS_KM / KM_PER_DEGREE;
    double lonDelta = SEARCH_RADIUS_KM /
            (KM_PER_DEGREE * Math.cos(Math.toRadians(latitude)));

    double minLat = latitude - latDelta;
    double maxLat = latitude + latDelta;

    double minLon = longitude - lonDelta;
    double maxLon = longitude + lonDelta;


    List<ResponderLocation> availableResponder =
            responderLocationRepository.findAvailableRespondersInBoundingBox(
                    minLat,
                    maxLat,
                    minLon,
                    maxLon);

    log.debug("Responders found in bounding box: {}", availableResponder.size());

    if (availableResponder.isEmpty()) {
        return null;
    }

    ResponderLocation bestResponder = null;
    double bestDistance = Double.MAX_VALUE;

    for (ResponderLocation responder : availableResponder) {

        double distance = geoService.calculateDistance(
                latitude,
                longitude,
                responder.getLatitude(),
                responder.getLongitude());

        log.trace("Responder {} distance = {}", responder.getResponderId(), distance);

        if (distance < bestDistance) {
            bestDistance = distance;
            bestResponder = responder;
        }
    }

    log.debug("Selected responder {}", bestResponder.getResponderId());

    return bestResponder;
}
}
