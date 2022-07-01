package com.demo.hypefast.controllers.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BaseError {
    @JsonInclude()
    private final int status;

    @JsonInclude()
    private final String message;

    public BaseError(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
