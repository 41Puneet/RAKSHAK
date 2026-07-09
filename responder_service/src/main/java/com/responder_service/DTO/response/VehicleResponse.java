package com.responder_service.DTO.response;

import java.util.UUID;

import com.responder_service.Enums.VehicleType;

public class VehicleResponse {
    private UUID id;
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String model;
    private int capacity;
    private boolean active;

    public VehicleResponse(){

    }
    public VehicleResponse(UUID id,VehicleType vehicleType,String vehicleNumber,String model,int capacity,boolean active){
        this.id=id;
        this.vehicleType=vehicleType;
        this.vehicleNumber=vehicleNumber;
        this.model=model;
        this.capacity=capacity;
        this.active=active;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
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
