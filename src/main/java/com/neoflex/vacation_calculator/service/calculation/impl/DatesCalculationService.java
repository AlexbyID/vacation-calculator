package com.neoflex.vacation_calculator.service.calculation.impl;

import com.neoflex.vacation_calculator.model.dto.VacationHolidaysCalendarDto;
import com.neoflex.vacation_calculator.model.request.VacationNonRequiredParamsRequest;
import com.neoflex.vacation_calculator.model.response.VacationResponse;
import com.neoflex.vacation_calculator.service.calculation.VacationCalculationService;
import com.neoflex.vacation_calculator.service.loader.JsonLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DatesCalculationService implements VacationCalculationService {
    @Autowired
    private JsonLoader loader;

    public VacationResponse calculate(double salary, VacationNonRequiredParamsRequest request) throws IOException {
        Set<LocalDate> holidays = loader.loadJson("/holidays.json").getHolidays().stream()
                .map(holiday -> {
                    String[] parts = holiday.getDate().split("-");
                    int month = Integer.parseInt(parts[0]);
                    int day = Integer.parseInt(parts[1]);
                    return LocalDate.of(LocalDate.now().getYear(), month, day);
                })
                .collect(Collectors.toSet());
        long vacationPeriod = request.getStartDate().datesUntil(request.getEndDate().plusDays(1))
                .filter(date -> {
                    DayOfWeek dayOfWeek = date.getDayOfWeek();
                    return !dayOfWeek.equals(DayOfWeek.SATURDAY)
                            && !dayOfWeek.equals(DayOfWeek.SUNDAY)
                            && !holidays.contains(date);
                })
                .count();
        return new VacationResponse(salary * vacationPeriod);
    }
}
