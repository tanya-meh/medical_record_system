package com.example.demo.dto.sickSheet;

import com.example.demo.data.entity.Examination;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateSickSheetDto {
    private LocalDate startDate;
    private int numOfDates;
}
