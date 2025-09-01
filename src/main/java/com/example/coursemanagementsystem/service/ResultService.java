package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.entitiy.Result;

import java.util.List;

public interface ResultService {
    List<Result> getAllResults();
    Result createResult(Result result);
    Result updateResult(Long id, Result result);
    void deleteResult(Long id);
}
