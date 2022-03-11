package com.api_visionplus.API.Vision.Plus.services;

import com.api_visionplus.API.Vision.Plus.common.EntityDtoConverter;
import com.api_visionplus.API.Vision.Plus.dto.AccountRequest;
import com.api_visionplus.API.Vision.Plus.dto.BalanceUpdateRequest;
import com.api_visionplus.API.Vision.Plus.entities.Account;
import com.api_visionplus.API.Vision.Plus.exceptions.AccountBadRequestException;
import com.api_visionplus.API.Vision.Plus.repositories.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @Override
    public Account save(AccountRequest a) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Account account = accountRepository.save(entityDtoConverter.convertAccountRequestToEntity(a));

        //ACCOUNT NUMBER HASH USING SHA-1
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(account.getNumber().getBytes("utf8"));
        String sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        account.setHash(sha1);

        return accountRepository.save(account);
    }

    @Override
    public Account getAccountByAccountNumberHash(String hash) {
        return(accountRepository.findAccountByHash(hash));
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account updateBalance(String hash, BalanceUpdateRequest balanceRequest) {
        Account a = accountRepository.findAccountByHash(hash);
        a.setBalance(balanceRequest.getBal_amt());
        accountRepository.save(a);
        return a;
    }

    @Override
    public List<Account> getAccountsBetweenMinAndMaxBalance(BigDecimal minRange, BigDecimal maxRange) {
        return accountRepository.findAccountByBalanceGreaterThanEqualAndBalanceLessThanEqual(minRange,maxRange);
    }
}
