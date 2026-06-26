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
@Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number")
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

}
