package com.example.demo.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
public class Doctor extends BaseEntity{
    private String keycloakId;

    @OneToOne(mappedBy = "doctor")
    private GP gp;

    @ManyToMany(mappedBy = "doctors")
    private Set<Specialty> specialties;

}
