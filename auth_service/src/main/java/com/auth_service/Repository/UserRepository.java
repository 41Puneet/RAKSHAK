package com.auth_service.Repository;


import java.util.Optional;
import java.util.UUID;
import com.auth_service.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID>{
    Optional<User>findByEmail(String email);

    Optional<User>findByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

}
