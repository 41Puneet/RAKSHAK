package com.responder_service.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.responder_service.Entity.Responder;
import com.responder_service.Enums.AvailabilityStatus;
import com.responder_service.Enums.DutyStatus;
import com.responder_service.Enums.ResponderType;

public interface ResponderRepository extends JpaRepository<Responder, UUID> {

    Optional<Responder> findByUserId(UUID userId);

    Optional<Responder> findByBadgeNumber(String badgeNumber);

    boolean existsByBadgeNumber(String badgeNumber);

    boolean existsByUserId(UUID userId);

    Page<Responder> findByResponderType(ResponderType responderType, Pageable pageable);

    Page<Responder> findByStatus(AvailabilityStatus status, Pageable pageable);

    Page<Responder> findByDutyStatus(DutyStatus dutyStatus, Pageable pageable);

    Page<Responder> findByActive(boolean active, Pageable pageable);

    Page<Responder> findByResponderTypeAndStatusAndDutyStatusAndActive(
            ResponderType responderType,
            AvailabilityStatus status,
            DutyStatus dutyStatus,
            boolean active,
            Pageable pageable);

    Page<Responder> findByCreatedAtBetween(
            LocalDateTime start,
            LocalDateTime end,
            Pageable pageable);

    @Query("select r from Responder r where r.id = :responderId")
    Responder findByResponderId(@Param("responderId") UUID responderId);
}
