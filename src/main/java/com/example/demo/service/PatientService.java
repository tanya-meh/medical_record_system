package com.example.demo.service;

import com.example.demo.dto.patient.CreatePatientDto;
import com.example.demo.dto.patient.PatientDto;
import com.example.demo.dto.patient.UpdatePatientDto;

import java.util.List;

public interface PatientService {
    List<PatientDto> getAllPatients();
    PatientDto getPatientById(long id);
    PatientDto createPatient(CreatePatientDto createPatientDto);
    PatientDto updatePatient(long id, UpdatePatientDto updatePatientDto);
    void deletePatient(long id);
}
