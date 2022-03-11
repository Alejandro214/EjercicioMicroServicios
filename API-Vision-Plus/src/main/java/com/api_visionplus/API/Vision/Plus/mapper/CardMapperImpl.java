package com.api_visionplus.API.Vision.Plus.mapper;

import com.api_visionplus.API.Vision.Plus.common.CardType;
import com.api_visionplus.API.Vision.Plus.entities.Card;
import com.api_visionplus.API.Vision.Plus.dto.CardResponse;
import com.api_visionplus.API.Vision.Plus.dto.NewCardRequest;
import org.mapstruct.Mapper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public class CardMapperImpl implements  ICardMapper{

    @Override
    public Card newCardReceivedToCardEntity(NewCardRequest newCardRequest) throws Exception {
        if(newCardRequest == null)
            return  null;

        Card card = new Card();
        String  accountNumberHash = this.stringSha1(newCardRequest.getAcct_nbr());
        String  cardNumberHast     = this.stringSha1(newCardRequest.getCard_nbr());
        card.setAccountNumberHash(accountNumberHash);
        card.setCardNumberHash(cardNumberHast);
        card.setCardNumber(newCardRequest.getCard_nbr());
        card.setExpirationDate(newCardRequest.getExp_date());
        card.setCardType(this.stringToCardTypeEnum(newCardRequest.getCard_type()));
        card.setCardHolderFirstName(newCardRequest.getFirst_name());
        card.setCardHolderLastName(newCardRequest.getLast_name());
        card.setSecurityCode(newCardRequest.getSec_code());
        return card;
    }

    private CardType stringToCardTypeEnum(String s){
        if(s.equals("credit"))
            return CardType.CREDIT;
        return CardType.DEBIT;
    }

    private String stringSha1(String s) throws Exception {
        String sha1;
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(s.getBytes("utf8"));
        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        return sha1;
    }

    @Override
    public List<CardResponse> listCardsToCardsDto(List<Card> cards) {
        if(cards.isEmpty())
            return  new ArrayList<>();
        List<CardResponse> listCardResponses = new ArrayList<>();
        for(Card card:cards ){
            CardResponse cardResponse = this.cardToCardDto(card);
            listCardResponses.add(cardResponse);
        }
        return listCardResponses;
    }

    @Override
    public CardResponse cardToCardDto(Card card) {
        if(card == null)
            return  null;
        CardResponse cardResponse = new CardResponse();
        cardResponse.setCardType(card.getCardType());
        cardResponse.setCardHolderFirstName(card.getCardHolderFirstName());
        cardResponse.setCardHolderLastName(card.getCardHolderLastName());
        return cardResponse;
    }
}
