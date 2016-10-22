package com.qph.restdemo.common;

import java.util.Map;

/**
 * Created by quocphan on 10/22/2016.
 */
public class RestException extends RuntimeException implements TranslatableToRestError{
    private final RestError restError;
    private Map<String, Object> errorParams;
    public RestError toRestError() {
        return this.restError;
    }

    public RestException(RestError restError, Map<String, Object> params) {
        this(restError);
        this.errorParams = params;
    }

    public RestException(RestError restError) {
        super(restError.getErrorMessage());
        this.restError = restError;
    }

    public RestException(TranslatableToRestError restError, Map<String, Object> params) {
        this(restError.toRestError());
        this.errorParams = params;
    }

    public RestException(TranslatableToRestError restError) {
        this(restError.toRestError());
    }

    public Map<String, Object> getErrorParams() {
        return this.errorParams;
    }
}
