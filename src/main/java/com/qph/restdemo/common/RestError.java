package com.qph.restdemo.common;

import org.springframework.http.HttpStatus;

/**
 * Created by quocphan on 10/22/2016.
 */
public final class RestError {
    private String errorCode;
    private String errorMessage;
    private HttpStatus httpStatus;

    public RestError(String errorCode, String errorMessage, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
