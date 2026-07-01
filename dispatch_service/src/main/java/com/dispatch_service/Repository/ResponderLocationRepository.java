package com.dispatch_service.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.dispatch_service.Entity.ResponderLocation;

import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.data.repository.query.Param;



public interface ResponderLocationRepository extends JpaRepository<ResponderLocation, UUID> {
    

    List<ResponderLocation>findByIsAvailableTrue();

    Optional<ResponderLocation>findByResponderId(UUID responderId);

   
   @Modifying
   @Transactional
    @Query("""
UPDATE ResponderLocation r
SET r.isAvailable = :status
WHERE r.responderId = :id
""")
int updateAvailability(
        @Param("id") UUID id,
        @Param("status") boolean status);


@Query("""
        SELECT r FROM ResponderLocation r WHERE r.isAvailable=true AND r.latitude BETWEEN  :minLat AND :maxLat AND r.longitude BETWEEN :minLon AND :maxLon
        """)
        List<ResponderLocation>findAvailableRespondersInBoundingBox(
            @Param("minLat")Double minLat,@Param("maxLat")Double maxLat,@Param("minLon")Double minLon,@Param("maxLon")Double maxLon
        );
}      