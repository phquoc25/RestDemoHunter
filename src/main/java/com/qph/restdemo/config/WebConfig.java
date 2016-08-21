package com.qph.restdemo.config;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by quocphan on 8/14/2016.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.printf("web startup");
    }
}
