package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.entitiy.Student;
import com.example.coursemanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repo;

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> existing = repo.findById(id);
        if (existing.isPresent()) {
            student.setId(id);
            return repo.save(student);
        }
        throw new RuntimeException("Course not found");
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
