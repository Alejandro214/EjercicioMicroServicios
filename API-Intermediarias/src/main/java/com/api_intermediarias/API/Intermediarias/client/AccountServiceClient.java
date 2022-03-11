package com.api_intermediarias.API.Intermediarias.client;

import com.api_intermediarias.API.Intermediarias.dto.AccountRequest;
import com.api_intermediarias.API.Intermediarias.dto.AccountResponse;
import com.api_intermediarias.API.Intermediarias.dto.BalanceUpdateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@FeignClient(name = "account",url = "http://localhost:8080")
public interface AccountServiceClient {

    @PostMapping("account/")
    ResponseEntity<AccountResponse> newAccount(@RequestBody AccountRequest a);

    @GetMapping("account/{accountNumberHash}")
    ResponseEntity<AccountResponse> getAccount(@PathVariable String accountNumberHash);

    @PutMapping("account/balance/{accountNumberHash}")
    ResponseEntity<AccountResponse> balanceUpdate(@PathVariable String accountNumberHash, @RequestBody BalanceUpdateRequest balanceRequest);

    @DeleteMapping("account/{accountNumberHash}")
    HttpStatus deteleAccount(@PathVariable String accountNumberHash, @RequestBody AccountRequest accountRequest);

    @GetMapping("account/balance")
    ResponseEntity<List<AccountResponse>> getAccountsByMinAndMaxBalance(@RequestParam BigDecimal minRange, @RequestParam BigDecimal maxRange);
}
