package com.example.demo.service;

import com.example.demo.dto.diagnosis.CreateDiagnosisDto;
import com.example.demo.dto.diagnosis.DiagnosisDto;
import com.example.demo.dto.diagnosis.UpdateDiagnosisDto;

import java.util.List;

public interface DiagnosisService {
    List<DiagnosisDto> getAllDiagnoses();
    DiagnosisDto getDiagnosisById(long id);
    DiagnosisDto createDiagnosis(CreateDiagnosisDto createDiagnosisDto);
    DiagnosisDto updateDiagnosis(long id, UpdateDiagnosisDto updateDiagnosisDto);
    void deleteDiagnosis(long id);
}
