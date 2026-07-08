package com.responder_service.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.responder_service.Entity.ResponderVehicle;

public interface ResponderVehicleRepository extends JpaRepository<ResponderVehicle,UUID>{
    
}
