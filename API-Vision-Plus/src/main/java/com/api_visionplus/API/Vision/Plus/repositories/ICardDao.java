package com.api_visionplus.API.Vision.Plus.repositories;

import com.api_visionplus.API.Vision.Plus.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICardDao extends JpaRepository<Card, String> {
    Card findByAccountNumberHashAndCardNumberHash(String accountNumberHash,String cardNumberHash);
    List<Card> findAllByAccountNumberHash(String accountNumberHash);

}


