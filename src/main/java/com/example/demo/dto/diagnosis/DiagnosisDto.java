package com.example.demo.dto.diagnosis;

import com.example.demo.data.entity.Examination;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiagnosisDto {
    private long id;
    private String name;
    private Set<Examination> examinations;
}
