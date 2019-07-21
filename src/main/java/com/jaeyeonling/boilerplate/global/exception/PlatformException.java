package com.jaeyeonling.boilerplate.global.exception;

import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class PlatformException extends RuntimeException {

    @Getter
    private final ErrorStatus errorStatus;

    PlatformException(final String message,
                      final ErrorStatus errorStatus) {
        super(message);

        this.errorStatus = errorStatus;
    }

    PlatformException(final ErrorStatus errorStatus) {
        this(errorStatus.name(), errorStatus);
    }

    abstract List<FieldError> fieldErrors();

    ResponseEntity<ErrorResponse> toResponse() {
        return ResponseEntity.status(errorStatus.getHttpStatus())
                .body(toBody());
    }

    ErrorResponse toBody() {
        return new ErrorResponse(errorStatus.getCode(), getMessage(), fieldErrors());
    }

    int getRawHttpStatus() {
        return errorStatus.getRawHttpStatus();
    }
}
