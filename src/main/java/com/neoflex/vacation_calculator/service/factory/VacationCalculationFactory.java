package com.neoflex.vacation_calculator.service.factory;

import com.neoflex.vacation_calculator.model.request.VacationNonRequiredParamsRequest;
import com.neoflex.vacation_calculator.model.response.VacationResponse;
import com.neoflex.vacation_calculator.service.calculation.impl.DatesCalculationService;
import com.neoflex.vacation_calculator.service.calculation.impl.DaysCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;

@Service
public class VacationCalculationFactory {
    @Autowired
    private DatesCalculationService datesCalculationService;

    @Autowired
    private DaysCalculationService daysCalculationService;

    public VacationResponse createCalculation(double salary, Integer days, LocalDate startDate, LocalDate endDate) throws IOException {
        if(days != null)
            return daysCalculationService.calculate(salary, new VacationNonRequiredParamsRequest(days));
        return datesCalculationService.calculate(salary, new VacationNonRequiredParamsRequest(startDate, endDate));
    }
}
