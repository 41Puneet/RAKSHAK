package com.auth_service.DTO.request;

import com.auth_service.Enums.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
public class RegisterRequest {


@NotBlank
private String fullName;
@NotBlank(message = "Email is required")
@Email(message = "Invalid email format")
private String email;
@NotBlank
@Pattern(regexp = "^[0-9]{10,15}$")
private String phoneNumber;
@NotBlank
@Size(min = 8, message = "Password must be at least 8 characters long")
private String password;
@NotNull
private Role role;
private String profileImageUrl;

public RegisterRequest(){

}
public RegisterRequest(String fullName,String email,String phoneNumber,String password,Role role,String profileImageUrl){
this.fullName=fullName;
this.email=email;
this.phoneNumber=phoneNumber;
this.password=password;
this.role=role;
this.profileImageUrl=profileImageUrl;
}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

}
