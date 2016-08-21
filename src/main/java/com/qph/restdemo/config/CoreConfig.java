package com.qph.restdemo.config;

import com.qph.restdemo.service.LanguageHandler;
import com.qph.restdemo.service.impl.EnHelloHandler;
import com.qph.restdemo.service.impl.FrHelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by quocphan on 8/16/2016.
 */
@Configuration
public class CoreConfig {
    @Bean
    public LanguageHandler getEnHelloHandler(){
        return new EnHelloHandler("en");
    }

    @Bean
    public LanguageHandler getFrHelloHandler(){
        return new FrHelloHandler("fr");
    }
}
