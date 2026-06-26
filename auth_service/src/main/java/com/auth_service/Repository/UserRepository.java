package com.auth_service.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface authServiceRepo extends JpaRepository<User, UUID>{
    
}
