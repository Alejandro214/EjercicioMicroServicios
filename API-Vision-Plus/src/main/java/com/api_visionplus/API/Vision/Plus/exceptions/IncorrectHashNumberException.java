package com.api_visionplus.API.Vision.Plus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IncorrectHashNumberException extends RuntimeException{

    public IncorrectHashNumberException(String message){
        super(message);
    }
}
