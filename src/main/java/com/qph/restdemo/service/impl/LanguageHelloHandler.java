package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.LanguageHandler;

/**
 * Created by quocphan on 8/16/2016.
 */
public abstract class LanguageHelloHandler implements LanguageHandler{
    protected String supportedLanguage = "en";

    public LanguageHelloHandler(String supportedLanguage) {
        this.supportedLanguage = supportedLanguage;
    }

    public boolean isSupported(String language) {
        return supportedLanguage.equalsIgnoreCase(language);
    }
}
