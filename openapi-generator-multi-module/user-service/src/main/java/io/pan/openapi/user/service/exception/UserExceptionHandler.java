package io.pan.openapi.user.service.exception;

import io.pan.openapi.user.api.model.Error;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Error> handleUserException(UserException cause) {
        return new ResponseEntity<>(
                new Error()
                        .message(cause.getMessage()),
                headers(),
                cause.getStatus()
        );
    }

    @ExceptionHandler({
            ConstraintViolationException.class,
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<Error> handleBadRequest(Exception cause) {
        return new ResponseEntity<>(
                new Error()
                        .message(cause.getMessage()),
                headers(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler
    public ResponseEntity<Error> handleAll(Exception cause) {
        return new ResponseEntity<>(
                new Error()
                        .message(cause.getMessage()),
                headers(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    private HttpHeaders headers() {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
