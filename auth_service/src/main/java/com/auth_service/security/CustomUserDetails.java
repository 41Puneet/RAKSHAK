package com.auth_service.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.auth_service.Entity.User;
import com.auth_service.Enums.AccountStatus;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    /**
     * Return complete User entity whenever needed
     */
    public User getUser() {
        return user;
    }

    /**
     * Converts Role into Spring Security Authority
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(
                new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
        );
    }

    /**
     * Password used during authentication
     */
    @Override
    public String getPassword() {
        return user.getPasswordHash();
    }

    /**
     * Username used during authentication
     * (Email in our case)
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Account never expires
     * (Can be changed later)
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Lock account if status is BLOCKED
     */
    @Override
    public boolean isAccountNonLocked() {
        return user.getAccountStatus() != AccountStatus.BLOCKED;
    }

    /**
     * Password never expires
     * (Can be changed later)
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Only ACTIVE users can login
     */
    @Override
    public boolean isEnabled() {
        return user.getAccountStatus() == AccountStatus.ACTIVE;
    }

}