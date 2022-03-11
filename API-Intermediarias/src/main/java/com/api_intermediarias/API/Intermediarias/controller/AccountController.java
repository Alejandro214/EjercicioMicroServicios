package com.api_intermediarias.API.Intermediarias.controller;

import com.api_intermediarias.API.Intermediarias.client.AccountServiceClient;
import com.api_intermediarias.API.Intermediarias.dto.AccountRequest;
import com.api_intermediarias.API.Intermediarias.dto.AccountResponse;
import com.api_intermediarias.API.Intermediarias.dto.BalanceUpdateRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Api
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServiceClient accountService;

    @ApiOperation(value = "Creates a new account", notes = "This operation creates a new account")
    @PostMapping("/")
    public ResponseEntity<AccountResponse> newAccount(@RequestBody AccountRequest a){
        return accountService.newAccount(a);
    }

    @ApiOperation(value = "Retrieve an account bassed on HashNumber", notes = "This operation returns an Account by HashNumber")
    @GetMapping("/{accountNumberHash}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable String accountNumberHash){
        return accountService.getAccount(accountNumberHash);
    }

    @ApiOperation(value = "Updates an Account", notes = "This operation updates an Account by HashNumber")
    @PutMapping("/balance/{accountNumberHash}")
    public ResponseEntity<AccountResponse> balanceUpdate(@PathVariable String accountNumberHash, @RequestBody BalanceUpdateRequest balanceRequest){
        return accountService.balanceUpdate(accountNumberHash,balanceRequest);
    }

    @ApiOperation(value = "Delete an Account", notes = "This operation deletes an Account by HashNumber")
    @DeleteMapping("/{accountNumberHash}")
    public HttpStatus deleteAccount(@PathVariable String accountNumberHash, @RequestBody AccountRequest accountRequest){
        return accountService.deteleAccount(accountNumberHash,accountRequest);
    }

    @ApiOperation(value = "Retrieve a list of accounts bassed on balance", notes = "This operation returns a List of Accounts by Balance")
    @GetMapping("/balance")
    public ResponseEntity<List<AccountResponse>> getAccountsByMinAndMaxBalance(@RequestParam BigDecimal minRange, @RequestParam BigDecimal maxRange){
        return accountService.getAccountsByMinAndMaxBalance(minRange,maxRange);
    }




}
