package com.responder_service.DTO.request;

import com.responder_service.Enums.VehicleType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterVehicleRequest {
    
    @NotNull
    private VehicleType vehicleType;
    @NotBlank
    private String vehicleNumber;
    @NotBlank
    private String model;
    @NotNull
    private Integer capacity;

    public RegisterVehicleRequest(){

    }
    public RegisterVehicleRequest(VehicleType vehicleType,String vehicleNumber,String model,Integer capacity){
        this.vehicleType=vehicleType;
        this.vehicleNumber=vehicleNumber;
        this.model=model;
        this.capacity=capacity;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    
}
