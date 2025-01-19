package com.example.matchodds.controllers.advice;

import io.swagger.v3.oas.annotations.Hidden;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Hidden
public class ExceptionHandlerAdvice {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleException(BadRequestException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}