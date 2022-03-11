package com.api_visionplus.API.Vision.Plus.common;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@Getter
@EnableJpaAuditing
public class VisionPlusConfig {


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
