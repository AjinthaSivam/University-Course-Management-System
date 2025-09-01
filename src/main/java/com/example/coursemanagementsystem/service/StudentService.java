package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.entitiy.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
