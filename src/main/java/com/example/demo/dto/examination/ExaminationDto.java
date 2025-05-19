package com.example.demo.dto.examination;

import com.example.demo.data.entity.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExaminationDto {
    private long id;
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime dateTime;

    private SickSheet sickSheet;
    private Set<MedicationPrescribed> prescribedSet;
    private Set<Diagnosis> diagnoses;
}
