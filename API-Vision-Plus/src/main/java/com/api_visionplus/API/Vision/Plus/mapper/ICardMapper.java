package com.api_visionplus.API.Vision.Plus.mapper;

import com.api_visionplus.API.Vision.Plus.dto.CardResponse;
import com.api_visionplus.API.Vision.Plus.entities.Card;
import com.api_visionplus.API.Vision.Plus.dto.NewCardRequest;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

public interface ICardMapper {
    @Mappings({
            @Mapping(target="accountNumberHash", source="newCardReceived.acct_nbr" ),
            @Mapping(target="cardNumberHash", source="newCardReceived.card_nbr"),
            @Mapping(target="cardNumber", source="newCardReceived.card_nbr"),
            @Mapping(target="expirationDate", source="newCardReceived.exp_date"),
            @Mapping(target="cardType", source="newCardReceived.card_type"),
            @Mapping(target="cardHolderFirstName", source="newCardReceived.first_name"),
            @Mapping(target="cardHolderLastName", source="newCardReceived.last_name"),
            @Mapping(target="securityCode", source="newCardReceived.sec_code"),
    })
    Card newCardReceivedToCardEntity(NewCardRequest newCardRequest) throws Exception;
    List<CardResponse> listCardsToCardsDto(List<Card> cards);
    CardResponse cardToCardDto(Card card);
}
