package com.example.demo.controller;

import com.example.demo.dto.sickSheet.CreateSickSheetDto;
import com.example.demo.dto.sickSheet.SickSheetDto;
import com.example.demo.dto.sickSheet.UpdateSickSheetDto;
import com.example.demo.service.impl.SickSheetServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableMethodSecurity(prePostEnabled = true)
@PreAuthorize("hasAuthority('doctor')")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sickSheet")
public class SickSheetController {
    private final SickSheetServiceImpl sickSheetService;

    @GetMapping
    public List<SickSheetDto> getSickSheets() {
        return sickSheetService.getAllSickSheets();
    }

    @GetMapping("/{id}")
    public SickSheetDto getSickSheetById(@PathVariable long id) {
        return sickSheetService.getSickSheetById(id);
    }

    @PostMapping
    public SickSheetDto createSickSheet(@RequestBody CreateSickSheetDto createSickSheetDto) {
        return sickSheetService.createSickSheet(createSickSheetDto);
    }

    @PutMapping("/{id}")
    public SickSheetDto updateSickSheet(@PathVariable long id, @RequestBody UpdateSickSheetDto updateSickSheetDto) {
        return sickSheetService.updateSickSheet(id, updateSickSheetDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSickSheet(@PathVariable long id) {
        sickSheetService.deleteSickSheet(id);
    }
}
