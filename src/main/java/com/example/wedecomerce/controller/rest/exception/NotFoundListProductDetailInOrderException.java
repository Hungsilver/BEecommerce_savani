package com.example.wedecomerce.controller.rest.exception;

import lombok.Getter;

public class NotFoundListProductDetailInOrderException extends BadRequestAlertException {

    private static final long serialVersionUID = 1L;

    public NotFoundListProductDetailInOrderException() {
        super(404, "not found", "Not found product detail in order");

    }

}
