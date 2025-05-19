package com.example.demo.data.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class MedicationPrescribed extends BaseEntity {
    @ManyToOne
    private Examination examination;

    @ManyToOne
    private Medication medication;

    private int amount;
}
