package com.example.demo.dto.sickSheet;

import com.example.demo.data.entity.Examination;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SickSheetDto {
    private long id;
    private Examination examination;
    private LocalDate startDate;
    private int numOfDates;
}
