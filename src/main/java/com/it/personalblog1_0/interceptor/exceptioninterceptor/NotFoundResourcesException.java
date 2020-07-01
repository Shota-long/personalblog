package com.it.personalblog1_0.interceptor.exceptioninterceptor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author lls
 * @version 1.0
 * @date 2020/5/23 17:21
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundResourcesException extends RuntimeException {

    public NotFoundResourcesException() {
        super();
    }

    public NotFoundResourcesException(String message) {
        super(message);
    }

    public NotFoundResourcesException(String message, Throwable cause) {
        super(message, cause);
    }
}
