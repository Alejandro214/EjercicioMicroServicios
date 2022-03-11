package com.api_visionplus.API.Vision.Plus.services;

import com.api_visionplus.API.Vision.Plus.dto.CardResponse;
import com.api_visionplus.API.Vision.Plus.dto.CardRequestDelete;
import com.api_visionplus.API.Vision.Plus.dto.NewCardRequest;

import java.util.List;

public interface ICardService {
    CardResponse newCard(NewCardRequest newCardRequest) throws Exception;
    CardResponse getCard(String accountNumberHash, String cardNumberHash);
    void deleteCard(CardRequestDelete cardRequestDelete);
    List<CardResponse> getListCardDto(String accountNumberHash);



}
