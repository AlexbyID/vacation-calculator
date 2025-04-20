package com.neoflex.vacation_calculator.config;

import com.neoflex.vacation_calculator.exception.api.ApiError;
import com.neoflex.vacation_calculator.exception.api.vacation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiError> handleInvalidSalaryException(InvalidVacationSalaryException ex){
        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                OffsetDateTime.now()
        );
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleInvalidVacationDaysException(InvalidVacationDaysException ex){
        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                OffsetDateTime.now()
        );
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleMissingVacationDaysOrPeriodException(MissingVacationDaysOrPeriodException ex){
        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                OffsetDateTime.now()
        );
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleVacationDaysConflictWithPeriodException(VacationDaysConflictWithPeriodException ex){
        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                OffsetDateTime.now()
        );
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleInvalidVacationPeriodException(InvalidVacationPeriodException ex){
        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                OffsetDateTime.now()
        );
        return ResponseEntity.badRequest().body(error);
    }
}
