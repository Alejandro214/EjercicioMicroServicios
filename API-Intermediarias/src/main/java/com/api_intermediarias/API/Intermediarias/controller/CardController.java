package com.api_intermediarias.API.Intermediarias.controller;

import com.api_intermediarias.API.Intermediarias.common.ExceptionMessage;
import com.api_intermediarias.API.Intermediarias.dto.CardRequestDelete;
import com.api_intermediarias.API.Intermediarias.dto.CardResponse;
import com.api_intermediarias.API.Intermediarias.dto.NewCardRequest;
import com.api_intermediarias.API.Intermediarias.exceptions.CardBadRequestException;
import com.api_intermediarias.API.Intermediarias.exceptions.IncorrectHashNumberAndCardNumberHashException;
import com.api_intermediarias.API.Intermediarias.client.CardFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api
public class CardController {

    @Autowired
    private CardFeignClient cardFeignClient;


    @PostMapping("/newCard")
    @ApiOperation(value = "Create a new credit card",notes = "Returns the card created with the type of card, name and surname of the holder")
    public  ResponseEntity<CardResponse> newCard(@RequestBody NewCardRequest newCardRequest) throws CardBadRequestException {
        try {
            return this.cardFeignClient.newCard(newCardRequest);
        }catch (Exception e){
            throw new CardBadRequestException(ExceptionMessage.INCORRECT_ACCOUNT_INFO.getValue());

        }
    }


    @GetMapping("/accounts/{accountNumberHash}/cards/{cardNumberHash}")
    @ApiOperation(value = "Returns the card based on the accountNumber Hash and cardNumberHash")
    public ResponseEntity<CardResponse> getCard(@PathVariable String accountNumberHash, @PathVariable String cardNumberHash){
        try {
            return this.cardFeignClient.getCard(accountNumberHash,cardNumberHash);
        }catch (Exception e){
            throw new IncorrectHashNumberAndCardNumberHashException(ExceptionMessage.INCORRECT_HASH_NUMBER_AND_CARD_NUMBER.getValue());

        }
    }

    @DeleteMapping("/delete/card")
    @ApiOperation(value = "Delete the card",notes = "delete card based on accountNumberHash and cardNumberHash")
    public HttpStatus deleteCard(@RequestBody CardRequestDelete cardToDelete){
        try {
            return this.cardFeignClient.deleteCard(cardToDelete);
        }catch (Exception e) {
            throw new IncorrectHashNumberAndCardNumberHashException(ExceptionMessage.INCORRECT_HASH_NUMBER_AND_CARD_NUMBER.getValue());

        }
    }
    @GetMapping("/cards/{accountNumberHash}")
    @ApiOperation(value = "Return a list of cards",notes = "Return cards based on accountNumberHash")
    public ResponseEntity<List<CardResponse>> getCards(@PathVariable String accountNumberHash){
        return this.cardFeignClient.getCards(accountNumberHash);
    }

}
