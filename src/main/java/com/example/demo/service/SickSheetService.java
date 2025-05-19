package com.example.demo.service;

import com.example.demo.dto.sickSheet.CreateSickSheetDto;
import com.example.demo.dto.sickSheet.SickSheetDto;
import com.example.demo.dto.sickSheet.UpdateSickSheetDto;

import java.util.List;

public interface SickSheetService {
    List<SickSheetDto> getAllSickSheets();
    SickSheetDto getSickSheetById(long id);
    SickSheetDto createSickSheet(CreateSickSheetDto createSickSheetDto);
    SickSheetDto updateSickSheet(long id, UpdateSickSheetDto updateSickSheetDto);
    void deleteSickSheet(long id);
}
