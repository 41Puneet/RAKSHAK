package com.responder_service.Repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.responder_service.Entity.ResponderVehicle;
import com.responder_service.Enums.VehicleType;

public interface ResponderVehicleRepository extends JpaRepository<ResponderVehicle,UUID>{
    

    Page<ResponderVehicle> findByVehicleType(VehicleType vehicleType,Pageable pageable);

    Optional<ResponderVehicle>findByVehicleNumber(String vehicleNumber);

    Page<ResponderVehicle>findByActive(boolean active,Pageable pageable);

    boolean existsByVehicleNumber(String vehicleNumber);

    Optional<ResponderVehicle>findByResponder_Id(UUID responderId);





}
