package com.auth_service.Repository;

import java.util.Optional;
import java.util.UUID;

import com.auth_service.Entity.RefreshToken;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {
    Optional<RefreshToken>findById(UUID id);

    void deleteByUserId(UUID userId);

    Optional<RefreshToken>findByUserId(UUID id);
}
