package com.responder_service.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.responder_service.Entity.ResponderAssignment;
import com.responder_service.Enums.Assignment_Status;

public interface ResponderAssignmentRepository extends JpaRepository<ResponderAssignment,UUID>{
    
    Optional<ResponderAssignment> findByResponder_Id(UUID responderId);
    
    Optional<ResponderAssignment> findByResponder_IdAndStatus(UUID responderId,Assignment_Status status);

    Page<ResponderAssignment> getAllResponderAssignment(Pageable pageable);
}
