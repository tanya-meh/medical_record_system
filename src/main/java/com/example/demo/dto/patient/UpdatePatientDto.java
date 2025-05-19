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
public class UpdatePatientDto {
    private String keycloakId;
    private GP gp;
    private LocalDate lastDateInsured;

    private UpdatePatientDto(String keycloakId) {
        this.keycloakId = keycloakId;
    }

    private UpdatePatientDto(String keycloakId, GP gp) {
        this.keycloakId = keycloakId;
        this.gp = gp;
    }

    private UpdatePatientDto(String keycloakId, LocalDate lastDateInsured) {
        this.keycloakId = keycloakId;
        this.lastDateInsured = lastDateInsured;
    }
}
