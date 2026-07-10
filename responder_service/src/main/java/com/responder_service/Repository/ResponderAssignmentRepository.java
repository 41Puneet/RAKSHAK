package com.responder_service.Repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.responder_service.Entity.ResponderAssignment;
import com.responder_service.Enums.Assignment_Status;

public interface ResponderAssignmentRepository
        extends JpaRepository<ResponderAssignment, UUID> {

    Page<ResponderAssignment> findByResponder_Id(
            UUID responderId,
            Pageable pageable);

    Page<ResponderAssignment> findByResponder_IdAndStatus(
            UUID responderId,
            Assignment_Status status,
            Pageable pageable);

    Optional<ResponderAssignment> findByEmergencyId(UUID emergencyId);

    Page<ResponderAssignment> findByStatus(
            Assignment_Status status,
            Pageable pageable);

    boolean existsByEmergencyId(UUID emergencyId);

    Optional<ResponderAssignment> findById(UUID AssignmentId);
}