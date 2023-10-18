package com.bmapute.chocolate.infrastructure.errorHandler;

import com.bmapute.chocolate.domain.exception.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class MachineExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorMessage> handlerDomainException(DomainException ex) {
        var error = new ErrorMessage(700, new Date(), ex.getMessage());
        return ResponseEntity.status(700).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handlerIllegalArgumentException(IllegalArgumentException ex) {
        var error = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), new Date(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handlerGenericException(Exception ex) {
        var error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
