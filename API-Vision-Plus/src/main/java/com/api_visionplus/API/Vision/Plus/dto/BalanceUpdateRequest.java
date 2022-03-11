package com.api_visionplus.API.Vision.Plus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceUpdateRequest {

    private String acct_nbr;
    private BigDecimal bal_amt;
    private String op_id;
    private LocalDate eff_date;
}
