package com.example.demo.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Examination extends BaseEntity {
    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    private LocalDateTime dateTime;

    @ManyToMany
    private Set<Diagnosis> diagnoses;

    @OneToMany(mappedBy = "examination")
    private Set<MedicationPrescribed> prescribedSet;

    @OneToOne(mappedBy = "examination")
    private SickSheet sickSheet;
}
