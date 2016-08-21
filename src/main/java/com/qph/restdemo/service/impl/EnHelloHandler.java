package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.LanguageHandler;
import org.springframework.util.StringUtils;

/**
 * Created by quocphan on 8/16/2016.
 */
public class EnHelloHandler extends LanguageHelloHandler{

    public static final String DEFAULT_SALUTATION = "Hello guest";

    public EnHelloHandler(String supportedLanguage) {
        super(supportedLanguage);
    }

    @Override
    public String sayHello(String name) {
        String result;
        if(!StringUtils.isEmpty(name)){
            result = "Hello " + name;
        } else {
            result = DEFAULT_SALUTATION;
        }
        return result;
    }

}
