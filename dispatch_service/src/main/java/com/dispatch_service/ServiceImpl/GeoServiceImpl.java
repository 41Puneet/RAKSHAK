package com.dispatch_service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.dispatch_service.Service.GeoService;

@Service
public class GeoServiceImpl implements GeoService{

    @Override
    public double calculateDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
    final int earthRadius = 6371; 

    double latInRad=Math.toRadians(lat2-lat1);
    double lonInRad=Math.toRadians(lon2-lon1);

    double rlat1=Math.toRadians(lat1);
    double rlat2=Math.toRadians(lat2);

    double a =Math.sin(latInRad/2)*Math.sin(latInRad/2)+Math.cos(rlat1)*Math.cos(rlat2)*Math.sin(lonInRad/2)*Math.sin(lonInRad/2);
    double c=2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

    return earthRadius*c;
    }

}