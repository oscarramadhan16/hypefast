package com.demo.hypefast.controllers;

import com.demo.hypefast.controllers.response.BaseError;
import com.demo.hypefast.controllers.response.BaseErrorResponse;
import com.demo.hypefast.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    private static final String GENERIC_RESPONSE_ERROR = "Couldn't process request";

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseErrorResponse> productNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(
                new BaseErrorResponse(
                        new BaseError(HttpStatus.NOT_FOUND.value(), e.getMessage())),
                HttpStatus.NOT_FOUND);
    }
}
