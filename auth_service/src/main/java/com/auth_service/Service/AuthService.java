package com.auth_service.Service;


import java.util.UUID;

import com.auth_service.DTO.Response.AuthResponse;
import com.auth_service.DTO.request.LoginRequest;
import com.auth_service.DTO.request.LogoutRequest;
import com.auth_service.DTO.request.RegisterRequest;
import com.auth_service.Entity.RefreshToken;



public interface AuthService {
    AuthResponse registerUser(RegisterRequest registerRequest);

    AuthResponse login(LoginRequest loginRequest);

    void logout(LogoutRequest token);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    RefreshToken createRefreshToken(UUID userId);

}
