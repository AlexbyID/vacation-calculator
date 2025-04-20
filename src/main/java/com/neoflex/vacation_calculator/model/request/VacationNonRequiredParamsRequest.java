package com.neoflex.vacation_calculator.model.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class VacationNonRequiredParamsRequest {
    private final Integer days;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public VacationNonRequiredParamsRequest(Integer days, LocalDate startDate, LocalDate endDate){
        this.days = days;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public VacationNonRequiredParamsRequest(LocalDate startDate, LocalDate endDate){
        this(null, startDate, endDate);
    }

    public VacationNonRequiredParamsRequest(Integer days){
        this(days, null, null);
    }
}
