package com.example.coursemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String role;
    private String email;
    private String name;
    private String studentNumber; // Only for students
}


