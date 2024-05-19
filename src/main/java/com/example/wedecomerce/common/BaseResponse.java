package com.example.wedecomerce.common;

import lombok.*;


@Builder
public class BaseResponse<T> {

    private final int code = 200;

    private final String message = "Success";

    private T data;


    public BaseResponse(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
