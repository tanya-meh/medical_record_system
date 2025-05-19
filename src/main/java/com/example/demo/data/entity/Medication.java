package com.example.demo.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Medication extends BaseEntity {
    private String name;

    @OneToMany(mappedBy = "medication")
    private Set<MedicationPrescribed> prescriptions;
}
