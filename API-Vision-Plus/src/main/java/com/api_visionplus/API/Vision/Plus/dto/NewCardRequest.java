package com.api_visionplus.API.Vision.Plus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@ApiModel(description = "Class representing  an newCard")
public class NewCardRequest {
    @NotNull
    @ApiModelProperty(notes = "Account number",example = "758759756")
    private String    acct_nbr;
    @NotNull
    @ApiModelProperty(notes = "Card number",example = "4257 8899 4444 4444")
    private String    card_nbr;
    @NotNull
    @ApiModelProperty(notes = "Expiration date",example = "20-02-2023")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate exp_date;
    @NotNull
    @ApiModelProperty(notes = "Card Type",example = "CREDIT")
    private String     card_type;
    @NotNull
    @ApiModelProperty(notes = "Card Holder",example = "Pep Argento")
    private String    crdhldr_det;
    @NotNull
    @ApiModelProperty(notes = "First Name",example = "Pepe")
    private String    first_name;
    @NotNull
    @ApiModelProperty(notes = "Last Name",example = "Argento")
    private String    last_name;
    @NotNull
    @ApiModelProperty(notes = "Security code",example = "123")
    private String    sec_code;


}
