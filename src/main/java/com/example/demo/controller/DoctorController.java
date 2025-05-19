package com.example.demo.controller;

import com.example.demo.dto.doctor.CreateDoctorDto;
import com.example.demo.dto.doctor.DoctorDto;
import com.example.demo.dto.doctor.UpdateDoctorDto;
import com.example.demo.service.impl.DoctorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableMethodSecurity(prePostEnabled = true)
@PreAuthorize("hasAuthority('doctor')")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doctor")
public class DoctorController {
    private final DoctorServiceImpl doctorService;

    @GetMapping
    public List<DoctorDto> getDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorDto getDoctorById(@PathVariable long id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public DoctorDto createDoctor(@RequestBody CreateDoctorDto createDoctorDto) {
        return doctorService.createDoctor(createDoctorDto);
    }

    @PutMapping("/{id}")
    public DoctorDto updateDoctor(@PathVariable long id, @RequestBody UpdateDoctorDto updateDoctorDto) {
        return doctorService.updateDoctor(id, updateDoctorDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable long id) {
        doctorService.deleteDoctor(id);
    }
}
