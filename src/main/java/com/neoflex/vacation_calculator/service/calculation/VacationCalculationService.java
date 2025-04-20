package com.neoflex.vacation_calculator.service.calculation;

import com.neoflex.vacation_calculator.model.request.VacationNonRequiredParamsRequest;
import com.neoflex.vacation_calculator.model.response.VacationResponse;

import java.io.IOException;

public interface VacationCalculationService {
    public abstract VacationResponse calculate(double salary, VacationNonRequiredParamsRequest request) throws IOException;
}
