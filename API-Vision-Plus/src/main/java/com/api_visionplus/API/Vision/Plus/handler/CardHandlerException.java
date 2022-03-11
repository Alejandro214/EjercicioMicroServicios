package com.api_visionplus.API.Vision.Plus.handler;

import com.api_visionplus.API.Vision.Plus.exceptions.CardBadRequestException;
import com.api_visionplus.API.Vision.Plus.exceptions.CardHandlerExceptionResponse;
import com.api_visionplus.API.Vision.Plus.exceptions.IncorrectHashNumberAndCardNumberHashException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice()
@RestController
public class CardHandlerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request){
        CardHandlerExceptionResponse response = new CardHandlerExceptionResponse(e.getMessage(),request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(CardBadRequestException.class)
    public ResponseEntity<Object> handleCardBadRequestException(Exception e,WebRequest request){
        CardHandlerExceptionResponse response = new CardHandlerExceptionResponse(e.getMessage(),request.getDescription(false), HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(IncorrectHashNumberAndCardNumberHashException.class)
    public ResponseEntity<Object> handleIncorrectHashNumberAndCardNumberHashException(Exception e,WebRequest request){
        CardHandlerExceptionResponse response = new CardHandlerExceptionResponse(e.getMessage(),request.getDescription(false), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
