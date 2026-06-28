package com.auth_service.ServiceImpl;

import java.time.LocalDateTime;

import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth_service.DTO.Response.AuthResponse;
import com.auth_service.DTO.request.LoginRequest;
import com.auth_service.DTO.request.LogoutRequest;
import com.auth_service.DTO.request.RegisterRequest;
import com.auth_service.Entity.RefreshToken;
import com.auth_service.Entity.User;
import com.auth_service.Enums.AccountStatus;
import com.auth_service.Repository.RefreshTokenRepository;
import com.auth_service.Repository.UserRepository;
import com.auth_service.Service.AuthService;
import com.auth_service.security.CustomUserDetailsService;
import com.auth_service.security.JwtService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class AuthServiceImpl implements AuthService{

private final UserRepository userRepository;
private final AuthenticationManager authenticationManager;
private final CustomUserDetailsService customUserDetailsService;
private final JwtService jwtService;
private final RefreshTokenRepository refreshTokenRepository;
private final PasswordEncoder passwordEncoder;

public AuthServiceImpl(UserRepository userRepository,AuthenticationManager authenticationManager,CustomUserDetailsService customUserDetailsService,JwtService jwtService,RefreshTokenRepository refreshTokenRepository,PasswordEncoder passwordEncoder){
    this.userRepository=userRepository;
    this.authenticationManager=authenticationManager;
    this.customUserDetailsService=customUserDetailsService;
    this.jwtService=jwtService;
    this.refreshTokenRepository=refreshTokenRepository;
    this.passwordEncoder=passwordEncoder;
}

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
      return userRepository.findByPhoneNumber(phoneNumber).isPresent();
        
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        User user =userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()->new IllegalArgumentException("User not found with this email:"+loginRequest.getEmail()));
        UserDetails userDetails=customUserDetailsService.loadUserByUsername(loginRequest.getEmail());
        String accessToken=jwtService.generateAccessToken(userDetails);
        RefreshToken refreshToken=createRefreshToken(user.getId());
        AuthResponse auth=new AuthResponse(accessToken, refreshToken.getToken(), "Bearer", jwtService.extractExpiration(accessToken).getTime(), user.getFullName(), user.getId(), user.getRole());
        return auth;
    }

    @Override
    public void logout(LogoutRequest token) {
        RefreshToken refreshToken=refreshTokenRepository.findByToken(token.getToken()).orElseThrow(()->new IllegalArgumentException("Token not found:"+token));
        refreshTokenRepository.delete(refreshToken);
    }

    

    @Override
    public AuthResponse registerUser(RegisterRequest registerRequest) {
       boolean emailExists = userRepository.existsByEmail(registerRequest.getEmail());
       if(emailExists){
        throw new IllegalArgumentException("User already registered with this email:"+registerRequest.getEmail());
       }
       boolean userByPhone = userRepository.existsByPhoneNumber(registerRequest.getPhoneNumber());
       if(userByPhone){
        throw new IllegalArgumentException("User already present with this phone number:"+registerRequest.getPhoneNumber());
       }
       User user1=new User();
       user1.setFullName(registerRequest.getFullName());
       user1.setEmail(registerRequest.getEmail());
       user1.setPhoneNumber(registerRequest.getPhoneNumber());
       user1.setPasswordHash(passwordEncoder.encode(registerRequest.getPassword()));
       user1.setRole(registerRequest.getRole());
       user1.setAccountStatus(AccountStatus.ACTIVE);
       user1.setProfileImageUrl(registerRequest.getProfileImageUrl());
       User saved=userRepository.save(user1);
        return mapToResponseDTO(saved);
    }
   
     private RefreshToken createRefreshToken(UUID userId) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUserId(userId);
        refreshToken.setToken(
                UUID.randomUUID().toString());
        refreshToken.setExpiryDate(
                LocalDateTime.now().plusDays(7));
        return refreshTokenRepository.save(refreshToken);
    }
    private AuthResponse mapToResponseDTO(User user){
        if(user == null){
            return null;
        }
       UserDetails userDetails=customUserDetailsService.loadUserByUsername(user.getEmail());
        String accessToken=jwtService.generateAccessToken(userDetails);
        RefreshToken refreshToken=createRefreshToken(user.getId());
        AuthResponse auth =new AuthResponse();
        auth.setAccessToken(accessToken);
        auth.setRefreshToken(refreshToken.getToken());
        auth.setTokenType("Bearer");
        auth.setUserId(user.getId());
        auth.setRole(user.getRole());
        return auth;
    }
    
}
