package com.example.wedecomerce.controller.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestAlertException.class)
    public ResponseEntity<BaseExceptionResponse> handleNotFoundException(BadRequestAlertException ex) {
        BaseExceptionResponse response = BaseExceptionResponse.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .messageError(ex.getMessageError())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
