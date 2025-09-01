package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.entitiy.Result;
import com.example.coursemanagementsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository repo;

    @Override
    public List<Result> getAllResults() {
        return repo.findAll();
    }

    @Override
    public Result createResult(Result result) {
        return repo.save(result);
    }

    @Override
    public Result updateResult(Long id, Result result) {
        Optional<Result> existing = repo.findById(id);
        if (existing.isPresent()) {
            result.setId(id);
            return repo.save(result);
        }
        throw new RuntimeException("Result not found");
    }

    @Override
    public void deleteResult(Long id) {
        repo.deleteById(id);
    }
}
