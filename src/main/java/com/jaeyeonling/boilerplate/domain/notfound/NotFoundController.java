package com.jaeyeonling.boilerplate.domain.notfound;

import com.jaeyeonling.boilerplate.global.exception.PlatformException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotFoundController {

    private static final PlatformException NOT_FOUND_EXCEPTION = new NotFoundException();

    @RequestMapping
    public void notFound() {
        throw NOT_FOUND_EXCEPTION;
    }
}
