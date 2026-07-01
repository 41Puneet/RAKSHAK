package com.dispatch_service.Service;


    public interface GeoService {

    double calculateDistance(
            Double lat1,
            Double lon1,
            Double lat2,
            Double lon2
    );
}

