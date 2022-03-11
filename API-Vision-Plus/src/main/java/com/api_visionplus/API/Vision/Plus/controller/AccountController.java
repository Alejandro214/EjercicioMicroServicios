package com.api_visionplus.API.Vision.Plus.controller;

import com.api_visionplus.API.Vision.Plus.common.EntityDtoConverter;
import com.api_visionplus.API.Vision.Plus.common.ExceptionMessagesEnum;
import com.api_visionplus.API.Vision.Plus.dto.AccountRequest;
import com.api_visionplus.API.Vision.Plus.dto.AccountResponse;
import com.api_visionplus.API.Vision.Plus.dto.BalanceUpdateRequest;
import com.api_visionplus.API.Vision.Plus.entities.Account;
import com.api_visionplus.API.Vision.Plus.exceptions.AccountBadRequestException;
import com.api_visionplus.API.Vision.Plus.exceptions.IncorrectHashNumberException;
import com.api_visionplus.API.Vision.Plus.services.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.IncompleteAnnotationException;
import java.math.BigDecimal;
import java.util.List;

@Api
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @ApiOperation(value = "Creates a new account", notes = "This operation creates a new account")
    @PostMapping("/")
    public ResponseEntity<AccountResponse> newAccount(@RequestBody AccountRequest a){
        try {
            Account account = accountService.save(a);
            return new ResponseEntity<>(entityDtoConverter.convertAccountEntityToAccountResponse(account), HttpStatus.CREATED);
        } catch (Exception e){
            throw new AccountBadRequestException(ExceptionMessagesEnum.INCORRECT_ACCOUNT_INFO.getValue());
        }
    }

    @ApiOperation(value = "Retrieve an account bassed on HashNumber", notes = "This operation returns an Account by HashNumber")
    @GetMapping("/{accountNumberHash}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable String accountNumberHash){
        try {
            Account account = accountService.getAccountByAccountNumberHash(accountNumberHash);
            return new ResponseEntity<>(entityDtoConverter.convertAccountEntityToAccountResponse(account), HttpStatus.OK);
        }
        catch (Exception e){
            throw new IncorrectHashNumberException(ExceptionMessagesEnum.INCORRECT_HASH_NUMBER.getValue());
        }
    }

    @ApiOperation(value = "Updates an Account", notes = "This operation updates an Account by HashNumber")
    @PutMapping("/balance/{accountNumberHash}")
    public ResponseEntity<AccountResponse> balanceUpdate(@PathVariable String accountNumberHash, @RequestBody BalanceUpdateRequest balanceRequest){
        try{
            Account a = accountService.updateBalance(accountNumberHash,balanceRequest);
            return new ResponseEntity<>(entityDtoConverter.convertAccountEntityToAccountResponse(a),HttpStatus.OK);
        }catch (Exception e){
            throw new IncorrectHashNumberException(ExceptionMessagesEnum.INCORRECT_HASH_NUMBER.getValue());
        }
    }

    @ApiOperation(value = "Delete an Account", notes = "This operation deletes an Account by HashNumber")
    @DeleteMapping("/{accountNumberHash}")
    public HttpStatus deteleAccount(@PathVariable String accountNumberHash, @RequestBody AccountRequest accountRequest){
        try {
            Account account = accountService.getAccountByAccountNumberHash(accountNumberHash);
            accountService.delete(account);
            return HttpStatus.NO_CONTENT;
        }
        catch (Exception e){
            throw new IncorrectHashNumberException(ExceptionMessagesEnum.INCORRECT_HASH_NUMBER.getValue());
        }
    }

    @ApiOperation(value = "Retrieve a list of accounts bassed on balance", notes = "This operation returns a List of Accounts by Balance")
    @GetMapping("/balance")
    public ResponseEntity<List<AccountResponse>> getAccountsByMinAndMaxBalance(@RequestParam BigDecimal minRange, @RequestParam BigDecimal maxRange){
        List<Account> accounts = accountService.getAccountsBetweenMinAndMaxBalance(minRange,maxRange);
        return new ResponseEntity<>(entityDtoConverter.convertAccountEntityToDto(accounts),HttpStatus.OK);
    }
}
