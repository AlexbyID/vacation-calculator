package com.neoflex.vacation_calculator.exception.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

@Getter
@RequiredArgsConstructor
public class ApiError {
    private final HttpStatus status;
    private final String message;
    private final OffsetDateTime timestamp;
}
