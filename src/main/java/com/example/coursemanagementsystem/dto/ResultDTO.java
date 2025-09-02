package com.example.coursemanagementsystem.dto;

import lombok.Data;

@Data
public class ResultDTO {
    private Long id;
    private String studentNumber;
    private String courseCode;
    private String courseName;
    private String grade;
}
