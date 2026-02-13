package com.example.backend_gym.Dto;
import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}