package com.api_intermediarias.API.Intermediarias.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ApiModel(description = "Class representing  an newCard")
public class NewCardRequest {

    @ApiModelProperty(notes = "Account number",example = "758759756")

    private String    acct_nbr;
    @ApiModelProperty(notes = "Card number",example = "4257 8899 4444 4444")
    private String    card_nbr;
    @ApiModelProperty(notes = "Expiration date",example = "20-02-2023")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate exp_date;
    @ApiModelProperty(notes = "Card Type",example = "CREDIT")
    private String     card_type;
    @ApiModelProperty(notes = "Card Holder",example = "Pep Argento")
    private String    crdhldr_det;
    @ApiModelProperty(notes = "First Name",example = "Pepe")
    private String    first_name;
    @ApiModelProperty(notes = "Last Name",example = "Argento")
    private String    last_name;
    @ApiModelProperty(notes = "Security code",example = "123")
    private String    sec_code;

}
