package com.neoflex.vacation_calculator.exception.api.vacation;

import java.time.LocalDate;

public class MissingVacationDaysOrPeriodException extends RuntimeException{
    public MissingVacationDaysOrPeriodException(Integer days, LocalDate startDate, LocalDate endDate){
        super(String.format("Missing period or amount days. Received %d days, Period - (%s - %s)", days, startDate, endDate));
    }
}
