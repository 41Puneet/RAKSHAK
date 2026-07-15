package com.hospital_service.Service;


import com.hospital_service.DTO.Response.HospitalResponse;
import com.hospital_service.Event.event.EmergencyPriorityUpdatedEvent;

public interface HospitalService {
    HospitalResponse findNearestHospital(EmergencyPriorityUpdatedEvent event);
}
