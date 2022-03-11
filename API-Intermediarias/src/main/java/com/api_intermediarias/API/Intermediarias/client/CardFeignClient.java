package com.api_intermediarias.API.Intermediarias.client;

import com.api_intermediarias.API.Intermediarias.dto.CardRequestDelete;
import com.api_intermediarias.API.Intermediarias.dto.CardResponse;
import com.api_intermediarias.API.Intermediarias.dto.NewCardRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="card", url = "http://localhost:8080")
public interface CardFeignClient {

    @PostMapping("card/newCard")
    ResponseEntity<CardResponse> newCard(@RequestBody NewCardRequest newCardRequest) throws Exception;

    @GetMapping("card/accounts/{accountNumberHash}/cards/{cardNumberHash}")
    public ResponseEntity<CardResponse> getCard(@PathVariable String accountNumberHash, @PathVariable String cardNumberHash);

    @DeleteMapping("card/delete/card")
    public HttpStatus deleteCard(@RequestBody CardRequestDelete cardToDelete);

    @GetMapping("card/cards/{accountNumberHash}")
    public ResponseEntity<List<CardResponse>> getCards(@PathVariable String accountNumberHash);

}
