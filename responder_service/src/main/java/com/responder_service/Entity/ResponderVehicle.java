package com.responder_service.Entity;

import java.util.UUID;
import com.responder_service.Enums.VehicleType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="responder_vehicle")
public class ResponderVehicle {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @Column(nullable=false,unique=true)
    private String vehicleNumber;
    @Column(nullable=false)
    private String model;
    @Column(nullable=false)
    private int capacity;
    @Column(nullable=false)
    private boolean active;

    @OneToOne
    @JoinColumn(name="responder_id",nullable=false,unique=true)
    private Responder responder;

    public ResponderVehicle(){

    }
    public ResponderVehicle(UUID id,VehicleType vehicleType,String vehicleNumber,String model,int capacity,boolean active,Responder responder){
        this.id=id;
        this.vehicleType=vehicleType;
        this.vehicleNumber=vehicleNumber;
        this.capacity=capacity;
        this.active=active;
        this.responder=responder;
        this.model=model;
    }
    public Responder getResponder() {
        return responder;
    }
    public void setResponder(Responder responder) {
        this.responder = responder;
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
