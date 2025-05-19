package com.example.demo.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import javax.print.Doc;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Specialty extends BaseEntity{
    private String name;

    @ManyToMany
    private Set<Doctor> doctors;
}
