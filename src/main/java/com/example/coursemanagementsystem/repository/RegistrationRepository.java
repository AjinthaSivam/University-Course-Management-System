package com.example.coursemanagementsystem.repository;

import com.example.coursemanagementsystem.entitiy.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
