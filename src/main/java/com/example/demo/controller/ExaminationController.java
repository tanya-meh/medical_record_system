package com.example.demo.controller;

import com.example.demo.dto.examination.CreateExaminationDto;
import com.example.demo.dto.examination.ExaminationDto;
import com.example.demo.dto.examination.UpdateExaminationDto;
import com.example.demo.service.impl.ExaminationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableMethodSecurity(prePostEnabled = true)
@PreAuthorize("hasAuthority('doctor')")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/examination")
public class ExaminationController {
    private final ExaminationServiceImpl examinationService;

    @GetMapping
    public List<ExaminationDto> getExaminations() {
        return examinationService.getAllExaminations();
    }

    @GetMapping("/{id}")
    public ExaminationDto getExaminationById(@PathVariable long id) {
        return examinationService.getExaminationById(id);
    }

    @PostMapping
    public ExaminationDto createExamination(@RequestBody CreateExaminationDto createExaminationDto) {
        return examinationService.createExamination(createExaminationDto);
    }

    @PutMapping("/{id}")
    public ExaminationDto updateExamination(@PathVariable long id, @RequestBody UpdateExaminationDto updateExaminationDto) {
        return examinationService.updateExamination(id, updateExaminationDto);
    }

    @DeleteMapping("/{id}")
    public void deleteExamination(@PathVariable long id) {
        examinationService.deleteExamination(id);
    }
}
