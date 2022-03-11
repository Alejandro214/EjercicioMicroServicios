package com.api_intermediarias.API.Intermediarias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private String number;
    private String hash;
    private String lastName;
    private BigDecimal balance;
    private Enum currencyCode;
    private String addressCountry;
    private String addressCity;
    private String addressStreet;
    private Integer addressNumber;
    private LocalDate dateBirth;



}
