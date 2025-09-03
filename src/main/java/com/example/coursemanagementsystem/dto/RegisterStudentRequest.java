package com.example.coursemanagementsystem.dto;

import lombok.Data;

@Data
public class RegisterStudentRequest {
    private String name;
    private String email;
    private String studentNumber;
    private String password;
}


