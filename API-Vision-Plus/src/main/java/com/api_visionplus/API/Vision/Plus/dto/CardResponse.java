package com.api_visionplus.API.Vision.Plus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardResponse {
    private String cardHolderFirstName;
    private String cardHolderLastName;
    private Enum   cardType;
}
