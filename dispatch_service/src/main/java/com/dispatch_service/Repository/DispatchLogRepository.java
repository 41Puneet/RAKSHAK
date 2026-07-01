package com.dispatch_service.Repository;


import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dispatch_service.Entity.DispatchLog;

public interface DispatchLogRepository extends JpaRepository<DispatchLog, UUID> {
    List<DispatchLog>findByEmergencyId(UUID id);

    List<DispatchLog>findTop10ByOrderByTimestampDesc();

}
