package com.example.wedecomerce.common;

import lombok.Builder;


@Builder
public class BaseErrorResponse {

    private int code;

    private String message;

    private final String data = null;

    private String codeMessage;

    private String codeMessageValue;

    public BaseErrorResponse(int code, String message, String codeMessage, String codeMessageValue) {
        this.code = code;
        this.message = message;
        this.codeMessage = codeMessage;
        this.codeMessageValue = codeMessageValue;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCodeMessage(String codeMessage) {
        this.codeMessage = codeMessage;
    }

    public void setCodeMessageValue(String codeMessageValue) {
        this.codeMessageValue = codeMessageValue;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }

    public String getCodeMessage() {
        return codeMessage;
    }

    public String getCodeMessageValue() {
        return codeMessageValue;
    }
}
