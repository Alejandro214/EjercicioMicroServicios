package com.api_intermediarias.API.Intermediarias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiIntermediariasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiIntermediariasApplication.class, args);
	}

}
