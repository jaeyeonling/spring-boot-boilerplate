package com.jaeyeonling.boilerplate.domain.post;

import com.jaeyeonling.boilerplate.global.exception.ErrorStatus;
import com.jaeyeonling.boilerplate.global.exception.NonFieldPlatformException;

class PostNotFoundException extends NonFieldPlatformException {

    private static final String ERROR_MESSAGE = "Post 를 찾을 수 없습니다. (입력 아이디: %d)";
    private static final ErrorStatus EXCEPTION_STATUS = ErrorStatus.POST_NOT_FOUND;

    PostNotFoundException(final long id) {
        super(String.format(ERROR_MESSAGE, id), EXCEPTION_STATUS);
    }
}
