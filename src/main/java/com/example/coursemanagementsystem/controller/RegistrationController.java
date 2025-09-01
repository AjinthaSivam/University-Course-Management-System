package com.example.coursemanagementsystem.controller;

import com.example.coursemanagementsystem.entitiy.Registration;
import com.example.coursemanagementsystem.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<Registration> getAll() {
        return service.getAllRegistrations();
    }

    @PostMapping
    public Registration create(@RequestBody Registration registration) {
        return service.createRegistration(registration);
    }

    @PutMapping("/{id}")
    public Registration update(@PathVariable Long id, @RequestBody Registration registration) {
        return service.updateRegistration(id, registration);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRegistration(id);
    }

}
