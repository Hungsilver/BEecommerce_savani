package com.example.wedecomerce.controller.rest.exception;

public class NotFoundException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;

//    private final String message;

    public NotFoundException(String message) {
        super(404, "not found", message);
//        this.message = message;
    }

}
