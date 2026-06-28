package com.auth_service.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth_service.DTO.request.LoginRequest;
import com.auth_service.DTO.request.RegisterRequest;
import com.auth_service.Service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        return new ResponseEntity<>(authService.registerUser(registerRequest), HttpStatus.CREATED);
    }
    @PostMapping("/logout/{token}")
    public ResponseEntity<Void> logout(@PathVariable String token){
        authService.logout(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.OK);
    }
}
