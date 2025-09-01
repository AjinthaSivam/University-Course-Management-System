package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.entitiy.Course;
import com.example.coursemanagementsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository repo;

    @Override
    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    @Override
    public Course createCourse(Course course) {
        return repo.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Optional<Course> existing = repo.findById(id);
        if (existing.isPresent()) {
            course.setId(id);
            return repo.save(course);
        }
        throw new RuntimeException("Course not found");
    }

    @Override
    public void deleteCourse(Long id) {
        repo.deleteById(id);
    }
}
