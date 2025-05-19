package com.example.demo.dto.diagnosis;

import com.example.demo.data.entity.Examination;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateDiagnosisDto {
    private String name;
    private Set<Examination> examinations;

    private UpdateDiagnosisDto(String name) {
        this.name = name;
    }

    private UpdateDiagnosisDto(Set<Examination> examinations) {
        this.examinations = examinations;
    }
}
