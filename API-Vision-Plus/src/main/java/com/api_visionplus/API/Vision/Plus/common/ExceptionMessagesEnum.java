package com.api_visionplus.API.Vision.Plus.common;

import lombok.Getter;

@Getter
public enum ExceptionMessagesEnum {
    INCORRECT_HASH_NUMBER("Hash number not found"),
    INCORRECT_ACCOUNT_INFO("The information provided is incorrect");

    ExceptionMessagesEnum(String message){value = message;}

    private final String value;
}
