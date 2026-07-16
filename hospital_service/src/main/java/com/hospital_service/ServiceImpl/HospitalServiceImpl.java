package com.hospital_service.ServiceImpl;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital_service.Client.OverRouteClient;
import com.hospital_service.Client.OverpassClient;
import com.hospital_service.DTO.Response.HospitalResponse;
import com.hospital_service.DTO.Response.OverpassResponse;
import com.hospital_service.DTO.Response.RouteResponse;
import com.hospital_service.DTO.Response.Summary;
import com.hospital_service.Event.Publisher.HospitalEventProducer;
import com.hospital_service.Event.event.EmergencyPriorityUpdatedEvent;
import com.hospital_service.Event.event.HospitalSelectionEvent;
import com.hospital_service.Service.HospitalService;
import com.hospital_service.DTO.Response.Element;
import com.hospital_service.DTO.Response.Tags;
import com.hospital_service.Enum.EmergencyType;

@Service
public class HospitalServiceImpl implements HospitalService{


    private final OverpassClient overpassClient;
    private final OverRouteClient overRouteClient;
    private final HospitalEventProducer producer;
    private final ObjectMapper objectMapper;

     public HospitalServiceImpl(
            OverpassClient overpassClient,
            OverRouteClient overRouteClient,
            HospitalEventProducer producer,
            ObjectMapper objectMapper) {

        this.overpassClient = overpassClient;
        this.overRouteClient = overRouteClient;
        this.producer = producer;
        this.objectMapper = objectMapper;
    }
    @Override
   public HospitalResponse findNearestHospital(EmergencyPriorityUpdatedEvent event) {
    try {

        List<HospitalResponse> hospitals = getNearbyHospitals(event);

        HospitalResponse nearestHospital =
                findBestHospital(hospitals,
                        event.getLatitude(),
                        event.getLongitude());

        HospitalSelectionEvent selectionEvent =
                buildHospitalAssignedEvent(event, nearestHospital);

        producer.publishHospitalEvent(selectionEvent);

        return nearestHospital;

    } catch (Exception e) {
        e.printStackTrace();
        throw e;
    }
}
    private List<HospitalResponse> getNearbyHospitals(
        EmergencyPriorityUpdatedEvent event) {
            try{
           String jsonResponse=overpassClient.getNearbyHospitals(event.getLatitude(), event.getLongitude());
           OverpassResponse overpassResponse=objectMapper.readValue(jsonResponse, OverpassResponse.class);
            return overpassResponse.getElements()
        .stream()
        .map(this::mapToHospitalResponse)
        .toList();
            
        }
            catch(Exception e){
                throw new RuntimeException("Failed to fetch nearby hospitals",e);
            }
}
 private HospitalResponse findBestHospital(List<HospitalResponse> hospitals,Double latitude,Double longitude) {
            if(hospitals==null||hospitals.isEmpty()){
                throw new IllegalArgumentException("No nearby hospitals found");
            }
            for(HospitalResponse hospital:hospitals){
                
                String routeJson = overRouteClient.getRoute(latitude, longitude, hospital.getLatitude(), hospital.getLongitude());
                System.out.println(routeJson);
                RouteResponse routeResponse;
                System.out.println(routeJson);
                try{
                    routeResponse=objectMapper.readValue(routeJson, RouteResponse.class);
                }
                catch(Exception e){
                    throw new RuntimeException("Unable to parse OpenRoute response",e);
                }
                if (routeResponse.getFeatures() == null ||
    routeResponse.getFeatures().isEmpty()) {
    continue;
}
                Summary summary = routeResponse.getFeatures()
                
                        .get(0)
                        .getProperties()
                        .getSegments()
                        .get(0)
                        .getSummary();
                        hospital.setDistance(summary.getDistance()/1000);
                        hospital.setEta(summary.getDuration()/60);
            }
            return hospitals.stream()
        .filter(h -> h.getEta() != null)
        .min(Comparator.comparing(HospitalResponse::getEta))
        .orElseThrow(() ->
                new RuntimeException("No valid hospital found"));
}
private HospitalSelectionEvent buildHospitalAssignedEvent(
        EmergencyPriorityUpdatedEvent event,
        HospitalResponse hospital) {
    return new HospitalSelectionEvent(
            java.util.UUID.randomUUID(),
            event.getEmergencyId(),
            EmergencyType.AMBULANCE,
            null,
            hospital.getHospitalName(),
            hospital.getAddress(),
            hospital.getLatitude(),
            hospital.getLongitude(),
            event.getLatitude(),
            event.getLongitude());
}
private HospitalResponse mapToHospitalResponse(Element element) {

    HospitalResponse response = new HospitalResponse();
    response.setHospitalName(
            element.getTags().getName());
    response.setLatitude(
            element.getLat());
    response.setLongitude(
            element.getLon());
    Tags tags = element.getTags();
   
    response.setAddress(tags.getFullAddress());

    return response;
}
}