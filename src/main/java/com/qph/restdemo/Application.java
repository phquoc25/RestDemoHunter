package com.qph.restdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by quocphan on 8/14/2016.
 */
/*@SpringBootApplication*/
    @Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.qph.restdemo"})
public class Application/* extends SpringBootServletInitializer*/{
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }*/
}
