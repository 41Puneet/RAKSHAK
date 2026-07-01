package com.dispatch_service.ServiceImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.dispatch_service.Entity.ResponderLocation;
import com.dispatch_service.Repository.ResponderLocationRepository;
import com.dispatch_service.Service.ResponderSelectionService;


public class ResponderSelectionServiceImpl implements ResponderSelectionService {

    private final GeoServiceImpl geoServiceImpl;
    private final ResponderLocationRepository responderLocationRepository;

    public ResponderSelectionServiceImpl(GeoServiceImpl geoServiceImpl, ResponderLocationRepository responderLocationRepository) {
        this.geoServiceImpl = geoServiceImpl;
        this.responderLocationRepository = responderLocationRepository;
    }

    @Override
    public ResponderLocation findNearestAvailableResponder(Double latitude, Double longitude) {
        Page<ResponderLocation> availableResponder = responderLocationRepository.findByIsAvailableTrue(PageRequest.of(0, 1));
        ResponderLocation bestResponder = null;
        double bestDistance = Double.MAX_VALUE;
        for (ResponderLocation responder : availableResponder) {
            double distance = geoServiceImpl.calculateDistance(latitude, longitude, responder.getLatitude(), responder.getLongitude());
            if (distance < bestDistance) {
                bestDistance = distance;
                bestResponder = responder;
            }
        }
        return bestResponder;
    }
    
}
