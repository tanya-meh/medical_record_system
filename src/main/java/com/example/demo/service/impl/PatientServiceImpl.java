package com.example.demo.service.impl;

import com.example.demo.config.ModelMapperConfig;
import com.example.demo.data.entity.Patient;
import com.example.demo.data.repo.PatientRepository;
import com.example.demo.dto.patient.CreatePatientDto;
import com.example.demo.dto.patient.PatientDto;
import com.example.demo.dto.patient.UpdatePatientDto;
import com.example.demo.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final ModelMapperConfig mapperConfig;

    @Override
    public List<PatientDto> getAllPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(patient -> mapperConfig.getModelMapper().map(patient, PatientDto.class))
                .toList();
    }

    @Override
    public PatientDto getPatientById(long id){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));

        return mapperConfig.getModelMapper().map(patient, PatientDto.class);
    }

    @Override
    public PatientDto createPatient(CreatePatientDto createPatientDto){
        Patient patient = mapperConfig.getModelMapper().map(createPatientDto, Patient.class);
        patient = patientRepository.save(patient);

        return mapperConfig.getModelMapper().map(patient, PatientDto.class);

    }

    @Override
    public PatientDto updatePatient(long id, UpdatePatientDto updatePatientDto){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
        mapperConfig.getModelMapper().map(updatePatientDto, patient);
        Patient updatedPatient = patientRepository.save(patient);

        return mapperConfig.getModelMapper().map(updatedPatient, PatientDto.class);
    }

    @Override
    public void deletePatient(long id){
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }


}
