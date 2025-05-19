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
public class DoctorDto {
    private long id;
    private String keycloakId;
    private GP gp;
    private Set<Specialty> specialties;

}
