package com.example.demo.controller;

import com.example.demo.dto.diagnosis.CreateDiagnosisDto;
import com.example.demo.dto.diagnosis.DiagnosisDto;
import com.example.demo.dto.diagnosis.UpdateDiagnosisDto;
import com.example.demo.service.impl.DiagnosisServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableMethodSecurity(prePostEnabled = true)
@PreAuthorize("hasAuthority('doctor')")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/diagnosis")
public class DiagnosisController {
    private final DiagnosisServiceImpl diagnosisService;

    @GetMapping
    public List<DiagnosisDto> getDiagnoses() {
        return diagnosisService.getAllDiagnoses();
    }

    @GetMapping("/{id}")
    public DiagnosisDto getDiagnosisById(@PathVariable long id) {
        return diagnosisService.getDiagnosisById(id);
    }

    @PostMapping
    public DiagnosisDto createDiagnosis(@RequestBody CreateDiagnosisDto createDiagnosisDto) {
        return diagnosisService.createDiagnosis(createDiagnosisDto);
    }

    @PutMapping("/{id}")
    public DiagnosisDto updateDiagnosis(@PathVariable long id, @RequestBody UpdateDiagnosisDto updateDiagnosisDto) {
        return diagnosisService.updateDiagnosis(id, updateDiagnosisDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDiagnosis(@PathVariable long id) {
        diagnosisService.deleteDiagnosis(id);
    }
}
