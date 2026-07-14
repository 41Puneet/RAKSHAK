package com.hospital_service.DTO.Response;

public class HospitalResponse {
    

    private String hospitalName;
    private String address;
    private Double latitude;
    private Double longitude;
    private Double distance;
    private Double eta;

    public HospitalResponse(){

    }
    public HospitalResponse(String hospitalName,String address,Double latitude,Double longitude,Double distance,Double eta){
        this.hospitalName=hospitalName;
        this.address=address;
        this.latitude=latitude;
        this.longitude=longitude;
        this.distance=distance;
        this.eta=eta;
    }
    public String getHospitalName() {
        return hospitalName;
    }
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public Double getDistance() {
        return distance;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    public Double getEta() {
        return eta;
    }
    public void setEta(Double eta) {
        this.eta = eta;
    }
    
}
