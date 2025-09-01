package com.example.coursemanagementsystem.controller;

import com.example.coursemanagementsystem.entitiy.Result;
import com.example.coursemanagementsystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {
    @Autowired
    private ResultService service;

    @GetMapping
    public List<Result> getAllResults() {
        return service.getAllResults();
    }

    @PostMapping
    public Result createResult(@RequestBody Result result) {
        return service.createResult(result);
    }

    @PutMapping("/{id}")
    public Result updateResult(@PathVariable Long id, @RequestBody Result result) {
        return service.updateResult(id, result);
    }

    @DeleteMapping("/{id}")
    public void deleteResult(@PathVariable Long id) {
        service.deleteResult(id);
    }

}
