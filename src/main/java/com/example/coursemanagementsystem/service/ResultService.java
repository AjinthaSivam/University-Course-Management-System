package com.example.coursemanagementsystem.service;

import com.example.coursemanagementsystem.dto.ResultDTO;
import com.example.coursemanagementsystem.entitiy.Result;

import java.util.List;

public interface ResultService {
    List<ResultDTO> getAllResults();
    ResultDTO createResult(ResultDTO resultDTO);
    ResultDTO updateResult(Long id, ResultDTO resultDTO);
    void deleteResult(Long id);
}
