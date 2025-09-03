package com.example.coursemanagementsystem.repository;

import com.example.coursemanagementsystem.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByStudentNumber(String studentNumber);
    boolean existsByEmail(String email);
    boolean existsByStudentNumber(String studentNumber);
}


