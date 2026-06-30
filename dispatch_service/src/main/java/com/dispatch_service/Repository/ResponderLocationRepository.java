package com.dispatch_service.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.dispatch_service.Entity.ResponderLocation;
import java.util.Optional;



public interface ResponderLocationRepository extends JpaRepository<ResponderLocation, UUID> {
    

    Page<ResponderLocation>findByIsAvailableTrue(Pageable pageable);

    Optional<ResponderLocation>findByResponderId(UUID responderId);

 @Modifying
@Query("UPDATE ResponderLocation r SET r.isAvailable = :status WHERE r.responderId = :id")
void updateAvailability(UUID id, boolean status);
}
