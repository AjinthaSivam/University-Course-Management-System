package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.entitiy.User;
import com.example.coursemanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public Optional<User> findByStudentNumber(String studentNumber) {
        return userRepository.findByStudentNumber(studentNumber);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    
    public boolean existsByStudentNumber(String studentNumber) {
        return userRepository.existsByStudentNumber(studentNumber);
    }
    
    public User createStudentUser(String name, String email, String studentNumber, String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setStudentNumber(studentNumber);
        user.setPassword(password);
        user.setRole(User.Role.STUDENT);
        return createUser(user);
    }
}


