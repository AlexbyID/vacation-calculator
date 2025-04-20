package com.neoflex.vacation_calculator.service.calculation.impl;

import com.neoflex.vacation_calculator.model.request.VacationNonRequiredParamsRequest;
import com.neoflex.vacation_calculator.model.response.VacationResponse;
import com.neoflex.vacation_calculator.service.calculation.VacationCalculationService;
import org.springframework.stereotype.Service;

@Service
public class DaysCalculationService implements VacationCalculationService {
    public VacationResponse calculate(double salary, VacationNonRequiredParamsRequest request){
        return new VacationResponse(salary * request.getDays());
    }
}
