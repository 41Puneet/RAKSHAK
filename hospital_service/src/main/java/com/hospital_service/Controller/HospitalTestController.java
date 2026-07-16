package com.hospital_service.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_service.DTO.Response.HospitalResponse;
import com.hospital_service.Event.event.EmergencyPriorityUpdatedEvent;
import com.hospital_service.Service.HospitalService;

@RestController
@RequestMapping("/test")
public class HospitalTestController {

    private final HospitalService hospitalService;

    public HospitalTestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @PostMapping("/hospital")
    public HospitalResponse testHospital(
            @RequestBody EmergencyPriorityUpdatedEvent event) {

        return hospitalService.findNearestHospital(event);
    }
}