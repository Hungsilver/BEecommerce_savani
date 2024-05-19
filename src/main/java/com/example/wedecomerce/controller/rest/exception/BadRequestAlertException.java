package com.example.wedecomerce.controller.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;

public class BadRequestAlertException extends RuntimeException {

    private final int code;
    private final String message;
    private final String messageError;

    public BadRequestAlertException(int code, String message, String messageError) {
        this.code = code;
        this.message = message;
        this.messageError = messageError;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getMessageError() {
        return messageError;
    }
}
