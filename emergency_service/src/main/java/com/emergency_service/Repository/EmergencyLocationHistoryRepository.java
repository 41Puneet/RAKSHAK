package com.emergency_service.Repository;

import java.util.UUID;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.emergency_service.Entity.EmergencyLocationHistory;

public interface EmergencyLocationHistoryRepository extends JpaRepository<EmergencyLocationHistory, UUID> {
    Optional<EmergencyLocationHistory> findTopByEmergencyRequestEmergencyIdOrderByRecorderAtDesc(UUID emergencyId);

    List<EmergencyLocationHistory> findByEmergencyRequestEmergencyIdOrderByRecorderAtAsc(UUID emergencyId);
    
    void deleteByRecorderAtBefore(LocalDateTime time);
}
