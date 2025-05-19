package com.example.demo.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Diagnosis extends BaseEntity {
    private String name;

    @ManyToMany(mappedBy = "diagnoses")
    private Set<Examination> examinations;
}
