package com.responder_service.DTO.request;

import java.util.UUID;

import com.responder_service.Enums.VehicleType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateVehicleRequest {
    @NotNull
    private VehicleType vehicleType;
    @NotBlank
    private String vehicleNumber;
    @NotBlank
    private String model;
    @Min(2)
    private int capacity;
    private boolean active;

    public UpdateVehicleRequest(){

    }
    public UpdateVehicleRequest(VehicleType vehicleType,String vehicleNumber,String model,int capacity,boolean active){
        
        this.vehicleNumber=vehicleNumber;
        this.vehicleType=vehicleType;
        this.model=model;
        this.capacity=capacity;
        this.active=active;
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
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

}
