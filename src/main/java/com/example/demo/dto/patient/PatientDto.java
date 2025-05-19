package com.example.demo.dto.patient;

import com.example.demo.data.entity.GP;
import com.example.demo.data.entity.Specialty;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientDto {
    private long id;
    private String keycloakId;
    private GP gp;
    private LocalDate lastDateInsured;

}
