package com.emergency_service.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emergency_service.Enums.Status;
import com.emergency_service.Entity.EmergencyRequest;
import com.emergency_service.Enums.EmergencyType;
import com.emergency_service.Enums.Priority;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface EmergencyRepository extends JpaRepository<EmergencyRequest, UUID> {
    Optional<EmergencyRequest>findByEmergencyId(UUID id);
    
    Page<EmergencyRequest>findByUserId(UUID userId,Pageable pageable);

    Page<EmergencyRequest>findByStatus(Status status,Pageable pageable);

    Page<EmergencyRequest>findByPriority(Priority priority,Pageable pageable);

    Page<EmergencyRequest>findByCreatedAtBetween(LocalDateTime startTime,LocalDateTime endTime,Pageable pageable);

    Page<EmergencyRequest>findByIsActive(boolean isActive,Pageable pageable);

    boolean existsByEmergencyId(UUID emergencyId);

    Page<EmergencyRequest> findByEmergencyType(EmergencyType emergencyType,Pageable pageable);
    @Query("""
SELECT e
FROM EmergencyRequest e
WHERE e.userId=:userId
AND e.isActive=true
""")
Optional<EmergencyRequest> findActiveEmergency(UUID userId);

Page<EmergencyRequest> findByResponderId(UUID responderId, Pageable pageable);
}
