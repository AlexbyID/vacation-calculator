package com.neoflex.vacation_calculator.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class VacationHolidaysCalendarDto {
    private Set<VacationHolidays> holidays;
}
