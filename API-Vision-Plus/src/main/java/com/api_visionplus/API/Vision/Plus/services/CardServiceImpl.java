package com.api_visionplus.API.Vision.Plus.services;

import com.api_visionplus.API.Vision.Plus.dto.CardResponse;
import com.api_visionplus.API.Vision.Plus.entities.Card;
import com.api_visionplus.API.Vision.Plus.repositories.ICardDao;
import com.api_visionplus.API.Vision.Plus.dto.CardRequestDelete;
import com.api_visionplus.API.Vision.Plus.mapper.ICardMapper;
import com.api_visionplus.API.Vision.Plus.dto.NewCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    private ICardDao iCardDao;

    @Autowired
    private ICardMapper iCardMapper;


    @Override
    public CardResponse newCard(NewCardRequest newCardRequest) throws Exception {
        Card card           = this.iCardMapper.newCardReceivedToCardEntity(newCardRequest);
        Card     cardSave   = this.iCardDao.save(card);
        CardResponse cardResponse = this.iCardMapper.cardToCardDto(cardSave);
        return cardResponse;
    }

    @Override
    public CardResponse getCard(String accountNumberHash, String cardNumberHash) {
        Card    card     = this.iCardDao.findByAccountNumberHashAndCardNumberHash(accountNumberHash,cardNumberHash);
        CardResponse cardResponse = this.iCardMapper.cardToCardDto(card);
        return cardResponse;
    }

    @Override
    public void deleteCard(CardRequestDelete cardRequestDelete) {
        Card card = this.iCardDao.findByAccountNumberHashAndCardNumberHash( cardRequestDelete.getAccountNumberHash(),
                cardRequestDelete.getCardNumberHash());
        this.iCardDao.delete(card);
    }

    @Override
    public List<CardResponse> getListCardDto(String accountNumberHash) {
        List<Card>      listCards   = this.iCardDao.findAllByAccountNumberHash(accountNumberHash);
        List<CardResponse> listCardResponse = this.iCardMapper.listCardsToCardsDto(listCards);
        return listCardResponse;
    }


}
