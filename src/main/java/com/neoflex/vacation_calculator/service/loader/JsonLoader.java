package com.neoflex.vacation_calculator.service.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoflex.vacation_calculator.model.dto.VacationHolidaysCalendarDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class JsonLoader {
    public VacationHolidaysCalendarDto loadJson(String filePath) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(inputStream, VacationHolidaysCalendarDto.class);
    }
}
