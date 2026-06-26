package com.auth_service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import com.auth_service.Repository.UserRepository;
import com.auth_service.Entity.User as UserEntity;


@Service
public class CustomUserDetailService implements UserDetailsService {

     private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found with this email:" + email));
        return user;
    }

   
}