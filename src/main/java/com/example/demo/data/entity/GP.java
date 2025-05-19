package com.example.demo.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class GP extends BaseEntity{
    @OneToOne
    private Doctor doctor;

    @OneToMany(mappedBy = "gp")
    private Set<Patient> patients;
}
