package com.example.demo.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class SickSheet extends BaseEntity{
    @OneToOne
//    @Column(unique = true)
    private Examination examination;

    private LocalDate startDate;
    private int numOfDates;
}
