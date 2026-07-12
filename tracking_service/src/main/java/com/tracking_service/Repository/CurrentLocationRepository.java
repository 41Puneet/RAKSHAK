package com.tracking_service.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tracking_service.Entity.CurrentLocation;

public interface CurrentLocationRepository extends JpaRepository<CurrentLocation,UUID> {
    
    CurrentLocation findByEntityId(UUID entityId);
}
