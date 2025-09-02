package com.example.coursemanagementsystem.repository;

import com.example.coursemanagementsystem.entitiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    Optional<Student> findByStudentNumber(String studentNumber);
}
