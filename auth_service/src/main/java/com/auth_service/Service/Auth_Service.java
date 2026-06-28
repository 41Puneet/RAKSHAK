package com.auth_service.Service;


import java.util.Optional;
import com.auth_service.DTO.Response.AuthResponse;
import com.auth_service.DTO.request.LoginRequest;
import com.auth_service.DTO.request.RegisterRequest;
import com.auth_service.Entity.User;


public interface Auth_Service {
    AuthResponse registerUser(RegisterRequest registerRequest);

    AuthResponse login(LoginRequest loginRequest);

    AuthResponse refreshToken(String token);

    void logout(String token);

    Optional<User>findByEmail(String email);

    Optional<User>findByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

}
