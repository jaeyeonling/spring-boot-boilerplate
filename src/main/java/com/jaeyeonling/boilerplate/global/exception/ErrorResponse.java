package com.jaeyeonling.boilerplate.global.exception;

import lombok.Getter;

import java.util.List;

@Getter
class ErrorResponse {

    private final int code;
    private final String message;
    private final List<FieldError> fieldErrors;

    ErrorResponse(final int code,
                  final String message,
                  final List<FieldError> fieldErrors) {
        this.code = code;
        this.message = message;
        this.fieldErrors = fieldErrors;
    }
}
