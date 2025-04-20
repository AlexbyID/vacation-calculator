package com.neoflex.vacation_calculator.exception.api.vacation;

import java.time.LocalDate;

public class VacationDaysConflictWithPeriodException extends RuntimeException{
    public VacationDaysConflictWithPeriodException(Integer days, LocalDate startDate, LocalDate endDate){
        super(String.format("Period can't set with amount days. Received - %d days, Period - (%s - %s)", days, startDate, endDate));
    }
}
