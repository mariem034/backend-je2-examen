package com.example.backend_gym.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.backend_gym.models.AppUser;
import com.example.backend_gym.repositories.UserRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String roleName = (appUser.getRole() != null) ? appUser.getRole().name() : "USER";
        return User.builder()
            .username(appUser.getUsername())
            .password(appUser.getPassword())
            .roles(roleName) // Convert enum to string
            .build();
    }
}



