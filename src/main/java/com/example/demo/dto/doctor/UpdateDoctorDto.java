package com.example.demo.dto.doctor;

import com.example.demo.data.entity.GP;
import com.example.demo.data.entity.Specialty;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateDoctorDto {
    private String keycloakId;
    private GP gp;
    private Set<Specialty> specialties;

    private UpdateDoctorDto(String keycloakId) {
        this.keycloakId = keycloakId;
    }

    private UpdateDoctorDto(String keycloakId, GP gp) {
        this.keycloakId = keycloakId;
        this.gp = gp;
    }

    private UpdateDoctorDto(String keycloakId, Set<Specialty> specialties) {
        this.keycloakId = keycloakId;
        this.specialties = specialties;
    }
}
