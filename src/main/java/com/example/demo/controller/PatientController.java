package com.example.demo.controller;

import com.example.demo.dto.patient.CreatePatientDto;
import com.example.demo.dto.patient.PatientDto;
import com.example.demo.dto.patient.UpdatePatientDto;
import com.example.demo.service.impl.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableMethodSecurity(prePostEnabled = true)
@PreAuthorize("hasAuthority('doctor')")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patient")
public class PatientController {
    private final PatientServiceImpl patientService;

    @GetMapping
    public List<PatientDto> getPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDto getPatientById(@PathVariable long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public PatientDto createPatient(@RequestBody CreatePatientDto createPatientDto) {
        return patientService.createPatient(createPatientDto);
    }

    @PutMapping("/{id}")
    public PatientDto updatePatient(@PathVariable long id, @RequestBody UpdatePatientDto updatePatientDto) {
        return patientService.updatePatient(id, updatePatientDto);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable long id) {
        patientService.deletePatient(id);
    }
}
