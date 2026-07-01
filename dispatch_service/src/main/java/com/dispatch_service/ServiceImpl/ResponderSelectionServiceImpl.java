package com.dispatch_service.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.dispatch_service.Service.GeoService;
import com.dispatch_service.Entity.ResponderLocation;
import com.dispatch_service.Repository.ResponderLocationRepository;
import com.dispatch_service.Service.ResponderSelectionService;


@Service
public class ResponderSelectionServiceImpl implements ResponderSelectionService {

    private final GeoService geoService;
    private final ResponderLocationRepository responderLocationRepository;

    public ResponderSelectionServiceImpl(GeoService geoService, ResponderLocationRepository responderLocationRepository) {
        this.geoService = geoService;
        this.responderLocationRepository = responderLocationRepository;
    }

    @Override
    public ResponderLocation findNearestAvailableResponder(Double latitude, Double longitude) {
        List<ResponderLocation> availableResponder = responderLocationRepository.findByIsAvailableTrue();
        if (availableResponder.isEmpty()) {
    return null;
}
        ResponderLocation bestResponder = null;
        double bestDistance = Double.MAX_VALUE;
        for (ResponderLocation responder : availableResponder) {
            double distance = geoService.calculateDistance(latitude, longitude, responder.getLatitude(), responder.getLongitude());
            if (distance < bestDistance) {
                bestDistance = distance;
                bestResponder = responder;
            }
        }
        return bestResponder;
    }
    
}
