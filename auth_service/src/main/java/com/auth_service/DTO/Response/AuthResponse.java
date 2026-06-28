package com.auth_service.DTO.Response;

import java.util.UUID;
import com.auth_service.Enums.Role;

public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Long expiresIn;
    private UUID UserId;
    private String fullName;
    private Role role;

    public AuthResponse(){

    }
    public AuthResponse(String accessToken,String refreshToken,String tokenType,Long expiresIn,String fullName,UUID id,Role role){
        this.accessToken=accessToken;
        this.refreshToken=refreshToken;
        this.tokenType=tokenType;
        this.expiresIn=expiresIn;
        this.UserId=id;
        this.fullName=fullName;
        this.role=role;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getRefreshToken() {
        return refreshToken;
    }
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public String getTokenType() {
        return tokenType;
    }
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    public Long getExpiresIn() {
        return expiresIn;
    }
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
    public UUID getUserId() {
        return UserId;
    }
    public void setUserId(UUID userId) {
        UserId = userId;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

}
