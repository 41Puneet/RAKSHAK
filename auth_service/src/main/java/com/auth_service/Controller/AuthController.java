package com.auth_service.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_service.DTO.Response.AuthResponse;
import com.auth_service.DTO.request.LoginRequest;
import com.auth_service.DTO.request.LogoutRequest;
import com.auth_service.DTO.request.RegisterRequest;
import com.auth_service.Service.AuthService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody @Valid RegisterRequest registerRequest){
        System.out.println("REGISTER CONTROLLER HIT");
        return new ResponseEntity<>(authService.registerUser(registerRequest), HttpStatus.CREATED);
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequest token){
        authService.logout(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest loginRequest){
        return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.OK);
    }
    
}
