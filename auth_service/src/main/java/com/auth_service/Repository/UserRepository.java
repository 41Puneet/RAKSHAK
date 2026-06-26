package com.auth_service.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.auth_service.Entity.User;
import com.auth_service.Enums.Role;
import com.auth_service.Enums.AccountStatus;

import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, UUID>{
    Optional<User>findByEmail(String email);

    Optional<User>findByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    List<User>findByRole(Role role);

    Page<User>findByRoleAndAccountStatus(Role role,AccountStatus accountStatus,Pageable pageable);

    List<User> findByRoleAndAccountStatus(Role role, AccountStatus accountStatus);
}
