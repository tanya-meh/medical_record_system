package com.example.demo.service.impl;

import com.example.demo.config.ModelMapperConfig;
import com.example.demo.data.entity.Doctor;
import com.example.demo.data.repo.DoctorRepository;
import com.example.demo.dto.doctor.CreateDoctorDto;
import com.example.demo.dto.doctor.DoctorDto;
import com.example.demo.dto.doctor.UpdateDoctorDto;
import com.example.demo.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final ModelMapperConfig mapperConfig;

    @Override
    public List<DoctorDto> getAllDoctors(){
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream()
                .map(doctor -> mapperConfig.getModelMapper().map(doctor, DoctorDto.class))
                .toList();
    }

    @Override
    public DoctorDto getDoctorById(long id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));

        return mapperConfig.getModelMapper().map(doctor, DoctorDto.class);
    }

    @Override
    public DoctorDto createDoctor(CreateDoctorDto createDoctorDto){
        Doctor doctor = mapperConfig.getModelMapper().map(createDoctorDto, Doctor.class);
        doctor = doctorRepository.save(doctor);

        return mapperConfig.getModelMapper().map(doctor, DoctorDto.class);

    }

    @Override
    public DoctorDto updateDoctor(long id, UpdateDoctorDto updateDoctorDto){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
        mapperConfig.getModelMapper().map(updateDoctorDto, doctor);
        Doctor updatedDoctor = doctorRepository.save(doctor);

        return mapperConfig.getModelMapper().map(updatedDoctor, DoctorDto.class);
    }

    @Override
    public void deleteDoctor(long id){
        if (!doctorRepository.existsById(id)) {
            throw new RuntimeException("Doctor not found with id: " + id);
        }
        doctorRepository.deleteById(id);
    }
}
