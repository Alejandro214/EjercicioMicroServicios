package com.api_visionplus.API.Vision.Plus.controller;

import com.api_visionplus.API.Vision.Plus.dto.CardRequestDelete;
import com.api_visionplus.API.Vision.Plus.dto.CardResponse;
import com.api_visionplus.API.Vision.Plus.dto.NewCardRequest;
import com.api_visionplus.API.Vision.Plus.exceptions.CardBadRequestException;
import com.api_visionplus.API.Vision.Plus.common.ExceptionMessage;
import com.api_visionplus.API.Vision.Plus.exceptions.IncorrectHashNumberAndCardNumberHashException;
import com.api_visionplus.API.Vision.Plus.services.ICardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("card")
public class CardController {

    @Autowired
    private ICardService iCardService;

    @ApiOperation(value = "Create a new credit card",notes = "Returns the card created with the type of card, name and surname of the holder")
    @PostMapping("/newCard")
    public ResponseEntity<CardResponse> newCard(@RequestBody NewCardRequest newCardRequest) throws Exception{
        try {
            CardResponse cardResponse = this.iCardService.newCard(newCardRequest);
            return new ResponseEntity<>(cardResponse, HttpStatus.CREATED);
        }catch (Exception e) {
            throw new CardBadRequestException(ExceptionMessage.INCORRECT_ACCOUNT_INFO.getValue());
        }


    }

    @ApiOperation(value = "Returns the card based on the accountNumber Hash and cardNumberHash")
    @GetMapping("/accounts/{accountNumberHash}/cards/{cardNumberHash}")
    public ResponseEntity<CardResponse> getCard(@PathVariable String accountNumberHash, @PathVariable String cardNumberHash){
        try {
            CardResponse cardResponse = this.iCardService.getCard(accountNumberHash, cardNumberHash);
            return new ResponseEntity<>(cardResponse, HttpStatus.OK);
        } catch (Exception e){
            throw new IncorrectHashNumberAndCardNumberHashException(ExceptionMessage.INCORRECT_HASH_NUMBER_AND_CARD_NUMBER.getValue());

        }
    }
    @ApiOperation(value = "Delete the card",notes = "delete card based on accountNumberHash and cardNumberHash")
    @DeleteMapping("/delete/card")
    public HttpStatus deleteCard(@RequestBody CardRequestDelete cardToDelete){
        try {
            this.iCardService.deleteCard(cardToDelete);
            return HttpStatus.NO_CONTENT;
        }catch (Exception e) {
            throw new IncorrectHashNumberAndCardNumberHashException(ExceptionMessage.INCORRECT_HASH_NUMBER_AND_CARD_NUMBER.getValue());

        }
    }
    @ApiOperation(value = "Return a list of cards",notes = "Return cards based on accountNumberHash")
    @GetMapping("/cards/{accountNumberHash}")
    public ResponseEntity<List<CardResponse>> getCards(@PathVariable String accountNumberHash){
        List<CardResponse> listCardResponses = this.iCardService.getListCardDto(accountNumberHash);
        return new ResponseEntity<>(listCardResponses, HttpStatus.OK);
    }
}
