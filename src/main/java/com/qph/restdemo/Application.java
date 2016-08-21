package com.qph.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by quocphan on 8/14/2016.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.qph.restdemo"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
