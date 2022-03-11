package com.api_intermediarias.API.Intermediarias.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {

    private String firstName;
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBirth;

    private String addressCountry;
    private String addressCity;
    private String addressStreet;
    private Integer addressNumber;
    private BigDecimal balance;
}
