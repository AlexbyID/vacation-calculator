package com.neoflex.vacation_calculator.controller;

import com.neoflex.vacation_calculator.model.response.VacationResponse;
import com.neoflex.vacation_calculator.service.factory.VacationCalculationFactory;
import com.neoflex.vacation_calculator.validator.vacation.VacationRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;

@RestController
public class CalculatorController {
    @Autowired
    private VacationRequestValidator requestValidator;

    @Autowired
    private VacationCalculationFactory calculationFactory;

    @GetMapping("/calculate")
    public ResponseEntity<VacationResponse> getVacation(@RequestParam double salary,
                            @RequestParam(required = false) Integer days,
                            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate,
                            @RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate) throws IOException {
        requestValidator.validate(salary, days, startDate, endDate);
        return ResponseEntity.ok().body(calculationFactory.createCalculation(salary, days, startDate, endDate));
    }
}
