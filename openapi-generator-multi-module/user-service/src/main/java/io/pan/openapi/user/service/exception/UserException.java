package io.pan.openapi.user.service.exception;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {

    private final HttpStatus status;

    public UserException(
            HttpStatus status,
            String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
