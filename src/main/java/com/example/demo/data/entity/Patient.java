package com.example.demo.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Patient extends BaseEntity {
    private String keycloakId;

    @ManyToOne
    private GP gp;

    private LocalDate lastDateInsured;
}
