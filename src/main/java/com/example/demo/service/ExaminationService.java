package com.example.demo.service;

import com.example.demo.dto.examination.CreateExaminationDto;
import com.example.demo.dto.examination.ExaminationDto;
import com.example.demo.dto.examination.UpdateExaminationDto;

import java.util.List;

public interface ExaminationService {
    List<ExaminationDto> getAllExaminations();
    ExaminationDto getExaminationById(long id);
    ExaminationDto createExamination(CreateExaminationDto createExaminationDto);
    ExaminationDto updateExamination(long id, UpdateExaminationDto updateExaminationDto);
    void deleteExamination(long id);
}
