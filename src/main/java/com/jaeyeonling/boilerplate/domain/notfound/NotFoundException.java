package com.jaeyeonling.boilerplate.domain.notfound;

import com.jaeyeonling.boilerplate.global.exception.ErrorStatus;
import com.jaeyeonling.boilerplate.global.exception.NonFieldPlatformException;

class NotFoundException extends NonFieldPlatformException {

    private static final ErrorStatus EXCEPTION_STATUS = ErrorStatus.NOT_FOUND;

    NotFoundException() {
        super(EXCEPTION_STATUS);
    }
}
