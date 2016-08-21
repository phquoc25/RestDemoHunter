package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.LanguageHandler;
import org.springframework.util.StringUtils;

/**
 * Created by quocphan on 8/16/2016.
 */
public class FrHelloHandler extends LanguageHelloHandler{

    public static final String DEFAULT_SALUTATION = "Bonjour invité";

    public FrHelloHandler(String supportedLanguage) {
        super(supportedLanguage);
    }

    @Override
    public String sayHello(String name) {
        String result;
        if(!StringUtils.isEmpty(name)){
            result = "Bonjour " + name;
        } else {
            result = DEFAULT_SALUTATION;
        }
        return result;
    }
}
