package com.auth_service.ServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import com.auth_service.DTO.Response.AuthResponse;
import com.auth_service.DTO.request.LoginRequest;
import com.auth_service.DTO.request.RegisterRequest;
import com.auth_service.Entity.User;
import com.auth_service.Repository.UserRepository;
import com.auth_service.Service.Auth_Service;
import com.auth_service.security.CustomUserDetailsService;
import com.auth_service.security.JwtService;

public class AuthServiceImpl implements Auth_Service{

private final UserRepository userRepository;
private final AuthenticationManager authenticationManager;
private final CustomUserDetailsService customUserDetailsService;
private final JwtService jwtService;

public AuthServiceImpl(UserRepository userRepository,AuthenticationManager authenticationManager,CustomUserDetailsService customUserDetailsService,JwtService jwtService){
    this.userRepository=userRepository;
    this.authenticationManager=authenticationManager;
    this.customUserDetailsService=customUserDetailsService;
    this.jwtService=jwtService;
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
        AuthResponse auth=new AuthResponse(accessToken, null, null, jwtService.extractExpiration(accessToken).getTime(), user.getFullName(), user.getId(), user.getRole());

        return auth;
    }

    @Override
    public void logout(String token) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public AuthResponse refreshToken(String token) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AuthResponse registerUser(RegisterRequest registerRequest) {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
