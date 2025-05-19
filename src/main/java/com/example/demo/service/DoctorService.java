package com.example.demo.service;

import com.example.demo.dto.doctor.CreateDoctorDto;
import com.example.demo.dto.doctor.DoctorDto;
import com.example.demo.dto.doctor.UpdateDoctorDto;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> getAllDoctors();
    DoctorDto getDoctorById(long id);
    DoctorDto createDoctor(CreateDoctorDto createDoctorDto);
    DoctorDto updateDoctor(long id, UpdateDoctorDto updateDoctorDto);
    void deleteDoctor(long id);
}
