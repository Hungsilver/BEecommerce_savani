package com.example.wedecomerce.controller.rest.exception;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@Builder
@NoArgsConstructor
public class BaseExceptionResponse {
    private int code;
    private String message;
    private final Object data = null;
    private String messageError;
}
