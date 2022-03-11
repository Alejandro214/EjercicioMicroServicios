package com.api_intermediarias.API.Intermediarias.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CardBadRequestException extends  RuntimeException{

    public CardBadRequestException(String message){

        super(message);
    }
}
