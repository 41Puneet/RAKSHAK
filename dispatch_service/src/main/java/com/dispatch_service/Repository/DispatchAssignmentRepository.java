package com.dispatch_service.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.dispatch_service.Entity.DispatchAssignment;
import com.dispatch_service.Enums.AssignmentStatus;

public interface DispatchAssignmentRepository extends JpaRepository<DispatchAssignment, UUID> {
    DispatchAssignment findByResponderId(UUID responderId);

    DispatchAssignment findByEmergencyId(UUID emergencyId);

    DispatchAssignment findByEmergencyIdAndStatus(UUID emergencyId, AssignmentStatus status);

    @Modifying
    @Transactional
    @Query("UPDATE DispatchAssignment d SET d.status = :status WHERE d.id = :id")
    int updateStatusById(@Param("id") UUID id, @Param("status") AssignmentStatus status);
}
