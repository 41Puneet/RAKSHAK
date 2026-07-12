package com.hospital_service.Service;

import com.hospital_service.DTO.Request.HospitalSearchRequest;
import com.hospital_service.DTO.Response.HospitalResponse;

public interface HospitalService {
    HospitalResponse findNearestHospital(HospitalSearchRequest request);
}
