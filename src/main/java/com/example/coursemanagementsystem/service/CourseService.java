package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.entitiy.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course createCourse(Course course);
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
}
