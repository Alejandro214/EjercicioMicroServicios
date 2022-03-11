package com.api_visionplus.API.Vision.Plus.entities;

import com.api_visionplus.API.Vision.Plus.common.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
@Table(name = "cards_tbl")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "CARD_NUMBER")
    private String cardNumber;


    @Column(name = "ACCOUNT_NUMBER_HASH", nullable = false)
    private String accountNumberHash;

    @Column(name = "CARD_NUMBER_HASH", nullable = false)
    private String cardNumberHash;


    @Column(name = "EXPIRATION_DATE",nullable = false)
    private  LocalDate expirationDate;

    @Column(name = "CARD_TYPE",nullable = false)
    private CardType cardType;

    @Column(name = "CARDHOLDER_FIRST_NAME",nullable = false)
    private  String cardHolderFirstName;

    @Column(name = "CARDHOLDER_LAST_NAME",nullable = false)
    private String cardHolderLastName;


    @Column(name = "SECURITY_CODE",nullable = false)
    private String securityCode;










}
