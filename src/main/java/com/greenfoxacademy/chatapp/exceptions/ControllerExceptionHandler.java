package com.greenfoxacademy.chatapp.exceptions;

import com.greenfoxacademy.chatapp.models.dtos.StatusMessageError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "Missing field(s): " +
                ex.getBindingResult().getAllErrors().stream()
                        .map((error) -> ((FieldError) error).getField())
                        .collect(Collectors.joining(", "));
        return ResponseEntity.status(401).body(new StatusMessageError(message));
    }

}
