package com.example.coursemanagementsystem.controller;

import com.example.coursemanagementsystem.entitiy.Course;
import com.example.coursemanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping
    public List<Course> getAll() {
        return service.getAllCourses();
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return service.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        return service.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCourse(id);
    }
}
