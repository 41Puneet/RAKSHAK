package com.hospital_service.Event.event;

import java.util.UUID;

import org.apache.tomcat.util.http.parser.Priority;

import com.hospital_service.enums.EmergencyType;

public class HospitalSelectionEvent {
    
    public class HospitalSelectedEvent {

    private UUID emergencyId;

    private UUID responderId;

    private EmergencyType emergencyType;

    private Priority priority;

    // Hospital Details
    private String hospitalId;          // OpenStreetMap id or provider id
    private String hospitalName;
    private String hospitalAddress;
    private String hospitalPhoneNumber; // if available

    // Location
    private Double latitude;
    private Double longitude;

    // Navigation
    private Double distanceInKm;
    private Double etaInMinutes;
    private String routeGeometry;       // optional

}
}
