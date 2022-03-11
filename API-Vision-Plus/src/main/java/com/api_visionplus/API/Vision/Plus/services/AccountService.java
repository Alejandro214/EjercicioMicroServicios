package com.api_visionplus.API.Vision.Plus.services;

import com.api_visionplus.API.Vision.Plus.dto.AccountRequest;
import com.api_visionplus.API.Vision.Plus.dto.BalanceUpdateRequest;
import com.api_visionplus.API.Vision.Plus.entities.Account;
import com.api_visionplus.API.Vision.Plus.exceptions.AccountBadRequestException;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface AccountService {

    Account save(AccountRequest a) throws NoSuchAlgorithmException, UnsupportedEncodingException;
    Account getAccountByAccountNumberHash(String hash);
    void delete(Account account);
    Account updateBalance(String hash, BalanceUpdateRequest balanceRequest);
    List<Account> getAccountsBetweenMinAndMaxBalance(BigDecimal minRange, BigDecimal maxRange);

}
