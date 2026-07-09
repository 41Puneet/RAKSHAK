package com.responder_service.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.responder_service.Entity.ResponderLocationHistory;

public interface ResponderLocationHistoryRepository
        extends JpaRepository<ResponderLocationHistory, UUID> {

    // Complete location history of a responder
    Page<ResponderLocationHistory> findByResponder_Id(
            UUID responderId,
            Pageable pageable);

    // Location history within a time range
    Page<ResponderLocationHistory> findByResponder_IdAndTimestampBetween(
            UUID responderId,
            LocalDateTime start,
            LocalDateTime end,
            Pageable pageable);

    // Latest location of a responder
    Optional<ResponderLocationHistory> findTopByResponder_IdOrderByTimestampDesc(
            UUID responderId);

    // All locations recorded during a time period
    Page<ResponderLocationHistory> findByTimestampBetween(
            LocalDateTime start,
            LocalDateTime end,
            Pageable pageable);
}