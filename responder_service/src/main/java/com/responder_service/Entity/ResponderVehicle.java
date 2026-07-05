package com.responder_service.Entity;

import java.util.UUID;

import com.responder_service.Enums.VehicleType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="responder_vehicle")
public class ResponderVehicle {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false)
    private UUID responderId;
    @Column(nullable=false)
    private VehicleType vehicleType;
    @Column(nullable=false)
    private String vehicleNumber;
    @Column(nullable=false)
    private String model;
    @Column(nullable=false)
    private int capacity;
    @Column(nullable=false)
    private boolean active;

    public ResponderVehicle(){

    }
    public ResponderVehicle(UUID id,UUID responderId,VehicleType vehicleType,String vehicleNumber,String model,int capacity,boolean active){
        this.id=id;
        this.responderId=responderId;
        this.vehicleType=vehicleType;
        this.vehicleNumber=vehicleNumber;
        this.capacity=capacity;
        this.active=active;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getResponderId() {
        return responderId;
    }
    public void setResponderId(UUID responderId) {
        this.responderId = responderId;
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
