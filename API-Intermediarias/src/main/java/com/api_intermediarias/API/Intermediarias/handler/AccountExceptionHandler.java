package com.api_intermediarias.API.Intermediarias.handler;

import com.api_intermediarias.API.Intermediarias.exceptions.AccountBadRequestException;
import com.api_intermediarias.API.Intermediarias.exceptions.AccountExceptionResponse;
import com.api_intermediarias.API.Intermediarias.exceptions.IncorrectHashNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class AccountExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request){
        AccountExceptionResponse response = new AccountExceptionResponse(e.getMessage(),request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(AccountBadRequestException.class)
    public ResponseEntity<Object> handleAccountBadRequest(Exception e,WebRequest request){
        AccountExceptionResponse response = new AccountExceptionResponse(e.getMessage(),request.getDescription(false), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(IncorrectHashNumberException.class)
    public ResponseEntity<Object> handleIncorrectHashNumber(Exception e,WebRequest request){
        AccountExceptionResponse response = new AccountExceptionResponse(e.getMessage(),request.getDescription(false), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
