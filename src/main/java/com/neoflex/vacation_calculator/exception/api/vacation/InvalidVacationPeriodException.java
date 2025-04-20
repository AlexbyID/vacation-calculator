package com.neoflex.vacation_calculator.exception.api.vacation;

import java.time.LocalDate;

public class InvalidVacationPeriodException extends RuntimeException{
    public InvalidVacationPeriodException(LocalDate startDate, LocalDate endDate){
        super(String.format("Start date date must be higher end date. Received (%s - %s)", startDate, endDate));
    }
}
