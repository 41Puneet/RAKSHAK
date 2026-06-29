package com.emergency_service.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emergency_service.Entity.EmergencyImage;
import java.util.Optional;

public interface EmergencyImageRepository extends JpaRepository<EmergencyImage, UUID>{
    @Override
    Optional<EmergencyImage> findById(UUID id);
}
