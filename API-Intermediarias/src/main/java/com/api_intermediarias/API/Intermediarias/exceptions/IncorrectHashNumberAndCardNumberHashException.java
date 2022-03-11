package com.api_intermediarias.API.Intermediarias.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectHashNumberAndCardNumberHashException extends  RuntimeException{

    public IncorrectHashNumberAndCardNumberHashException(String message){

        super(message);
    }
}
