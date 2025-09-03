package com.example.coursemanagementsystem.controller;

import com.example.coursemanagementsystem.dto.LoginRequest;
import com.example.coursemanagementsystem.dto.LoginResponse;
import com.example.coursemanagementsystem.dto.RegisterStudentRequest;
import com.example.coursemanagementsystem.entitiy.Student;
import com.example.coursemanagementsystem.entitiy.User;
import com.example.coursemanagementsystem.service.StudentService;
import com.example.coursemanagementsystem.service.UserService;
import com.example.coursemanagementsystem.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            User user = userService.findByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return ResponseEntity.badRequest().body(Map.of("error", "Invalid credentials"));
            }
            
            String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
            
            LoginResponse response = new LoginResponse(
                    token,
                    user.getRole().name(),
                    user.getEmail(),
                    user.getName(),
                    user.getStudentNumber()
            );
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Login failed: " + e.getMessage()));
        }
    }
    
    @PostMapping("/register-student")
    public ResponseEntity<?> registerStudent(@RequestBody RegisterStudentRequest request) {
        try {
            // Check if email already exists
            if (userService.existsByEmail(request.getEmail())) {
                return ResponseEntity.badRequest().body(Map.of("error", "Email already exists"));
            }
            
            // Check if student number already exists
            if (userService.existsByStudentNumber(request.getStudentNumber())) {
                return ResponseEntity.badRequest().body(Map.of("error", "Student number already exists"));
            }
            
            // Create user
            User user = userService.createStudentUser(
                    request.getName(),
                    request.getEmail(),
                    request.getStudentNumber(),
                    request.getPassword()
            );
            
            // Create student record
            Student student = new Student();
            student.setName(request.getName());
            student.setEmail(request.getEmail());
            student.setStudentNumber(request.getStudentNumber());
            student.setUser(user);
            studentService.createStudent(student);
            
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Student registered successfully");
            response.put("user", Map.of(
                    "id", user.getId(),
                    "name", user.getName(),
                    "email", user.getEmail(),
                    "studentNumber", user.getStudentNumber(),
                    "role", user.getRole().name()
            ));
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Registration failed: " + e.getMessage()));
        }
    }
    
    @PostMapping("/create-admin")
    public ResponseEntity<?> createAdmin(@RequestBody Map<String, String> request) {
        try {
            String name = request.get("name");
            String email = request.get("email");
            String password = request.get("password");
            
            if (userService.existsByEmail(email)) {
                return ResponseEntity.badRequest().body(Map.of("error", "Email already exists"));
            }
            
            User admin = new User();
            admin.setName(name);
            admin.setEmail(email);
            admin.setPassword(password);
            admin.setRole(User.Role.ADMIN);
            
            User savedAdmin = userService.createUser(admin);
            
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Admin created successfully");
            response.put("admin", Map.of(
                    "id", savedAdmin.getId(),
                    "name", savedAdmin.getName(),
                    "email", savedAdmin.getEmail(),
                    "role", savedAdmin.getRole().name()
            ));
            
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Admin creation failed: " + e.getMessage()));
        }
    }
}


