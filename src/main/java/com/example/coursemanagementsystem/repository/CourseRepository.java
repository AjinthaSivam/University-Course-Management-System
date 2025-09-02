package com.example.coursemanagementsystem.repository;

import com.example.coursemanagementsystem.entitiy.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCode(String code);
}
