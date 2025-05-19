package com.example.demo.service.impl;

import com.example.demo.config.ModelMapperConfig;
import com.example.demo.data.entity.Examination;
import com.example.demo.data.repo.ExaminationRepository;
import com.example.demo.dto.examination.CreateExaminationDto;
import com.example.demo.dto.examination.ExaminationDto;
import com.example.demo.dto.examination.UpdateExaminationDto;
import com.example.demo.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExaminationServiceImpl implements ExaminationService {
    private final ExaminationRepository examinationRepository;
    private final ModelMapperConfig mapperConfig;

    @Override
    public List<ExaminationDto> getAllExaminations(){
        List<Examination> examinations = examinationRepository.findAll();
        return examinations.stream()
                .map(examination -> mapperConfig.getModelMapper().map(examination, ExaminationDto.class))
                .toList();
    }

    @Override
    public ExaminationDto getExaminationById(long id){
        Examination examination = examinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Examination not found with id: " + id));

        return mapperConfig.getModelMapper().map(examination, ExaminationDto.class);
    }

    @Override
    public ExaminationDto createExamination(CreateExaminationDto createExaminationDto){
        Examination examination = mapperConfig.getModelMapper().map(createExaminationDto, Examination.class);
        examination = examinationRepository.save(examination);

        return mapperConfig.getModelMapper().map(examination, ExaminationDto.class);

    }

    @Override
    public ExaminationDto updateExamination(long id, UpdateExaminationDto updateExaminationDto){
        Examination examination = examinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Examination not found with id: " + id));
        mapperConfig.getModelMapper().map(updateExaminationDto, examination);
        Examination updatedExamination = examinationRepository.save(examination);

        return mapperConfig.getModelMapper().map(updatedExamination, ExaminationDto.class);
    }

    @Override
    public void deleteExamination(long id){
        if (!examinationRepository.existsById(id)) {
            throw new RuntimeException("Examination not found with id: " + id);
        }
        examinationRepository.deleteById(id);
    }
}
