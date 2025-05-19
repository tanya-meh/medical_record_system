package com.example.demo.service.impl;

import com.example.demo.config.ModelMapperConfig;
import com.example.demo.data.entity.Diagnosis;
import com.example.demo.data.repo.DiagnosisRepository;
import com.example.demo.dto.diagnosis.CreateDiagnosisDto;
import com.example.demo.dto.diagnosis.DiagnosisDto;
import com.example.demo.dto.diagnosis.UpdateDiagnosisDto;
import com.example.demo.service.DiagnosisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DiagnosisServiceImpl implements DiagnosisService {
    private final DiagnosisRepository diagnosisRepository;
    private final ModelMapperConfig mapperConfig;

    @Override
    public List<DiagnosisDto> getAllDiagnoses(){
        List<Diagnosis> diagnoses = diagnosisRepository.findAll();
        return diagnoses.stream()
                .map(diagnosis -> mapperConfig.getModelMapper().map(diagnosis, DiagnosisDto.class))
                .toList();
    }

    @Override
    public DiagnosisDto getDiagnosisById(long id){
        Diagnosis diagnosis = diagnosisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diagnosis not found with id: " + id));

        return mapperConfig.getModelMapper().map(diagnosis, DiagnosisDto.class);
    }

    @Override
    public DiagnosisDto createDiagnosis(CreateDiagnosisDto createDiagnosisDto){
        Diagnosis diagnosis = mapperConfig.getModelMapper().map(createDiagnosisDto, Diagnosis.class);
        diagnosis = diagnosisRepository.save(diagnosis);

        return mapperConfig.getModelMapper().map(diagnosis, DiagnosisDto.class);

    }

    @Override
    public DiagnosisDto updateDiagnosis(long id, UpdateDiagnosisDto updateDiagnosisDto){
        Diagnosis diagnosis = diagnosisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diagnosis not found with id: " + id));
        mapperConfig.getModelMapper().map(updateDiagnosisDto, diagnosis);
        Diagnosis updatedDiagnosis = diagnosisRepository.save(diagnosis);

        return mapperConfig.getModelMapper().map(updatedDiagnosis, DiagnosisDto.class);
    }

    @Override
    public void deleteDiagnosis(long id){
        if (!diagnosisRepository.existsById(id)) {
            throw new RuntimeException("Diagnosis not found with id: " + id);
        }
        diagnosisRepository.deleteById(id);
    }
}
