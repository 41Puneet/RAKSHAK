package com.emergency_service.Repository;

import java.util.UUID;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.emergency_service.Entity.ResponderAssignment;
import com.emergency_service.Enums.AssignmentStatus;



public interface ResponderAssignmentRepository extends JpaRepository<ResponderAssignment, UUID> {
    Optional<ResponderAssignment>findByResponderId (UUID id);
    Optional<ResponderAssignment>findByEmergencyRequestEmergencyId(UUID emergencyId);
    List<ResponderAssignment>findByStatus(AssignmentStatus status);
}
