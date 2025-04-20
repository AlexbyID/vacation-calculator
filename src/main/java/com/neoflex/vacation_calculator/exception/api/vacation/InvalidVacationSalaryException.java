package com.neoflex.vacation_calculator.exception.api.vacation;

public class InvalidVacationSalaryException extends RuntimeException{
    public InvalidVacationSalaryException(double salary){
        super("Salary must be positive. Received:" + salary);
    }
}
