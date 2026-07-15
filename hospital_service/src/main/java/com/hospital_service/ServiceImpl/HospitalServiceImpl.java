package com.hospital_service.ServiceImpl;
import com.hospital_service.DTO.Request.HospitalSearchRequest;
import com.hospital_service.DTO.Response.HospitalResponse;
import com.hospital_service.Event.event.EmergencyPriorityUpdatedEvent;
import com.hospital_service.Service.HospitalService;

public class HospitalServiceImpl implements HospitalService {

    @Override
    public HospitalResponse findNearestHospital(EmergencyPriorityUpdatedEvent event) {
        
        return null;
    }
    private HospitalResponse filterHospital(HospitalSearchRequest request){
        return mapper.toHospital
    }
    
}
