package com.example.coursemanagementsystem.repository;

import com.example.coursemanagementsystem.entitiy.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
