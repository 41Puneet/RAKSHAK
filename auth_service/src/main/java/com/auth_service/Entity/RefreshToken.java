package com.auth_service.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="refresh-token")
public class RefreshToken {

@Id
@GeneratedValue(strategy=GenerationType.UUID)
private UUID id;

@NotBlank
private String token;

@NotNull
private UUID userId;


private LocalDateTime expiryDate;

private boolean revoked;

private LocalDateTime createdAt;

public RefreshToken(){

}
public RefreshToken(UUID id,String token,UUID userId,LocalDateTime expiryDate,boolean revoked,LocalDateTime createdAt){
    this.id=id;
    this.token=token;
    this.userId=userId;
    this.expiryDate=expiryDate;
    this.revoked=revoked;
    this.createdAt=createdAt;
}
public UUID getId() {
    return id;
}
public void setId(UUID id) {
    this.id = id;
}
public String getToken() {
    return token;
}
public void setToken(String token) {
    this.token = token;
}
public UUID getUserId() {
    return userId;
}
public void setUserId(UUID userId) {
    this.userId = userId;
}
public LocalDateTime getExpiryDate() {
    return expiryDate;
}
public void setExpiryDate(LocalDateTime expiryDate) {
    this.expiryDate = expiryDate;
}
public boolean isRevoked() {
    return revoked;
}
public void setRevoked(boolean revoked) {
    this.revoked = revoked;
}
public LocalDateTime getCreatedAt() {
    return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}

}
