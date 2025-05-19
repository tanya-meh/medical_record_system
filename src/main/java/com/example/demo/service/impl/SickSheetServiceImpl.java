package com.example.demo.service.impl;

import com.example.demo.config.ModelMapperConfig;
import com.example.demo.data.entity.SickSheet;
import com.example.demo.data.repo.SickSheetRepository;
import com.example.demo.dto.sickSheet.CreateSickSheetDto;
import com.example.demo.dto.sickSheet.SickSheetDto;
import com.example.demo.dto.sickSheet.UpdateSickSheetDto;
import com.example.demo.service.SickSheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SickSheetServiceImpl implements SickSheetService {
    private final SickSheetRepository sickSheetRepository;
    private final ModelMapperConfig mapperConfig;

    @Override
    public List<SickSheetDto> getAllSickSheets(){
        List<SickSheet> sickSheets = sickSheetRepository.findAll();
        return sickSheets.stream()
                .map(sickSheet -> mapperConfig.getModelMapper().map(sickSheet, SickSheetDto.class))
                .toList();
    }

    @Override
    public SickSheetDto getSickSheetById(long id){
        SickSheet sickSheet = sickSheetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SickSheet not found with id: " + id));

        return mapperConfig.getModelMapper().map(sickSheet, SickSheetDto.class);
    }

    @Override
    public SickSheetDto createSickSheet(CreateSickSheetDto createSickSheetDto){
        SickSheet sickSheet = mapperConfig.getModelMapper().map(createSickSheetDto, SickSheet.class);
        sickSheet = sickSheetRepository.save(sickSheet);

        return mapperConfig.getModelMapper().map(sickSheet, SickSheetDto.class);

    }

    @Override
    public SickSheetDto updateSickSheet(long id, UpdateSickSheetDto updateSickSheetDto){
        SickSheet sickSheet = sickSheetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SickSheet not found with id: " + id));
        mapperConfig.getModelMapper().map(updateSickSheetDto, sickSheet);
        SickSheet updatedSickSheet = sickSheetRepository.save(sickSheet);

        return mapperConfig.getModelMapper().map(updatedSickSheet, SickSheetDto.class);
    }

    @Override
    public void deleteSickSheet(long id){
        if (!sickSheetRepository.existsById(id)) {
            throw new RuntimeException("SickSheet not found with id: " + id);
        }
        sickSheetRepository.deleteById(id);
    }
}
