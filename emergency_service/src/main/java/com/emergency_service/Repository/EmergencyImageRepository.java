package com.emergency_service.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.emergency_service.Entity.EmergencyImage;
import java.util.List;

public interface EmergencyImageRepository extends JpaRepository<EmergencyImage, UUID>{
    List<EmergencyImage>findByEmergencyRequestEmergencyId(UUID emergencyId);
    long countByEmergencyRequestEmergencyId(UUID emergencyId);
}
