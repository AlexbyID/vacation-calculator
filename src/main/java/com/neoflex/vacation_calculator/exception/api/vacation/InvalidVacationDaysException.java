package com.neoflex.vacation_calculator.exception.api.vacation;

public class InvalidVacationDaysException extends RuntimeException{
    public InvalidVacationDaysException(Integer days){
        super("Vacation days must be positive. Received:" + days);
    }
}
