package com.responder_service.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.responder_service.Entity.ResponderAvailabilityHistory;
import com.responder_service.Enums.AvailabilityStatus;

public interface ResponderAvailabilityRepository
        extends JpaRepository<ResponderAvailabilityHistory, UUID> {

    // Complete availability history of a responder
    Page<ResponderAvailabilityHistory> findByResponder_Id(
            UUID responderId,
            Pageable pageable);

    // History where responder changed TO a specific status
    Page<ResponderAvailabilityHistory> findByNewStatus(
            AvailabilityStatus status,
            Pageable pageable);

    // History where responder changed FROM a specific status
    Page<ResponderAvailabilityHistory> findByPreviousStatus(
            AvailabilityStatus status,
            Pageable pageable);

    // Changes made within a time period
    Page<ResponderAvailabilityHistory> findByChangedAtBetween(
            LocalDateTime start,
            LocalDateTime end,
            Pageable pageable);

    // Latest status change of a responder
    Optional<ResponderAvailabilityHistory> findTopByResponder_IdOrderByChangedAtDesc(
            UUID responderId);

            
}