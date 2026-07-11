package com.tracking_service.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tracking_service.Entity.LocationHistory;

public interface LocationHistoryRepository extends JpaRepository<LocationHistory,UUID>{
    

    Page<LocationHistory> findByEntityId(
            UUID entityId,
            Pageable pageable);

    Page<LocationHistory> findByEntityIdAndTimestampBetween(
            UUID entityId,
            LocalDateTime start,
            LocalDateTime end,
            Pageable pageable);
}
