package com.api_visionplus.API.Vision.Plus.common;

import com.api_visionplus.API.Vision.Plus.dto.AccountRequest;
import com.api_visionplus.API.Vision.Plus.dto.AccountResponse;
import com.api_visionplus.API.Vision.Plus.entities.Account;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public AccountRequest convertAccountEntityToDto(Account a){
        return modelMapper.map(a,AccountRequest.class);
    }

    public Account convertAccountRequestToEntity(AccountRequest a){
        return modelMapper.map(a,Account.class);
    }

    public List<AccountResponse> convertAccountEntityToDto(List<Account> accounts){
        return accounts.stream()
                .map(a -> this.convertAccountEntityToAccountResponse(a))
                .collect(Collectors.toList());
    }

    public AccountResponse convertAccountEntityToAccountResponse(Account a){
        return modelMapper.map(a,AccountResponse.class);
    }

}
