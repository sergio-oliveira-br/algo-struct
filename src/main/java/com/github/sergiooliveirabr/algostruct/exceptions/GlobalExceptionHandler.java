package com.github.sergiooliveirabr.algostruct.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ProblemDetails> buildErrorResponse (HttpStatus status, String message) {

        ProblemDetails problemDetails = new ProblemDetails(
                status.value(),
                message
        );
        return new ResponseEntity<>(problemDetails, status);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetails> exception (Exception e) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return buildErrorResponse(status, e.getMessage());
    }
}
