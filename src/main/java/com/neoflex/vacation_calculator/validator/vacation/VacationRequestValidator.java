package com.neoflex.vacation_calculator.validator.vacation;

import com.neoflex.vacation_calculator.exception.api.vacation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class VacationRequestValidator {
    public void validate(double salary, Integer days, LocalDate startDate, LocalDate endDate){
        if(salary <= 0)
            throw new InvalidVacationSalaryException(salary);
        if(days == null && (startDate == null || endDate == null))
            throw new MissingVacationDaysOrPeriodException(days, startDate, endDate);
        if(days != null && days < 0)
            throw new InvalidVacationDaysException(days);
        if(days !=null && days > 0  && (startDate != null || endDate != null))
            throw new VacationDaysConflictWithPeriodException(days, startDate, endDate);
        if(startDate != null && startDate.isAfter(endDate))
            throw new InvalidVacationPeriodException(startDate, endDate);
    }
}
