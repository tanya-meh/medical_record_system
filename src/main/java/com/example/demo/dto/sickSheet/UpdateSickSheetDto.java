package com.example.demo.dto.sickSheet;

import com.example.demo.data.entity.Examination;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateSickSheetDto {
    private Examination examination;
    private LocalDate startDate;
    private int numOfDates;

    public UpdateSickSheetDto(LocalDate startDate, int numOfDates) {
        this.startDate = startDate;
        this.numOfDates = numOfDates;
    }
}
