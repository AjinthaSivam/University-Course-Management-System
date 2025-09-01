package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.entitiy.Registration;
import com.example.coursemanagementsystem.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService{
    @Autowired
    private RegistrationRepository repo;

    @Override
    public List<Registration> getAllRegistrations() {
        return repo.findAll();
    }

    @Override
    public Registration createRegistration(Registration registration) {
        return repo.save(registration);
    }

    @Override
    public Registration updateRegistration(Long id, Registration registration) {
        Optional<Registration> existing = repo.findById(id);
        if (existing.isPresent()) {
            registration.setId(id);
            return repo.save(registration);
        }
        throw new RuntimeException("Registration not found");
    }

    @Override
    public void deleteRegistration(Long id) {
        repo.deleteById(id);
    }
}
