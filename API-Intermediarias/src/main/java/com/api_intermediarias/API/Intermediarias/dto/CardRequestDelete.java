package com.api_intermediarias.API.Intermediarias.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Class representing  an CardRequestDelete")
public class CardRequestDelete {
    @ApiModelProperty(notes = "Account NumberHash ",example = "7f5b8b5f9g7f6")
    private String accountNumberHash;
    @ApiModelProperty(notes = "Card NumberHash ",example = "bf5b8b5f9g7f6")
    private String cardNumberHash;

}
