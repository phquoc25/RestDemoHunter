package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.HelloService;
import com.qph.restdemo.service.LanguageHandler;
import com.qph.restdemo.service.exceptions.UnsupportedLanguageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quocphan on 8/14/2016.
 */
@Service
public class HelloServiceImpl implements HelloService{
    @Autowired
    private List<LanguageHandler> languageHandlers = new ArrayList<LanguageHandler>();

    @Override
    public String sayHello(final String name, String language) throws UnsupportedLanguageException {
        String result = "";
        boolean supportedLanguageFound = false;
        for (LanguageHandler languageHandler : languageHandlers){
            if(languageHandler.isSupported(language)) {
                result = languageHandler.sayHello(name);
                supportedLanguageFound = true;
                break;
            }
        }
        if (!supportedLanguageFound){
            throw new UnsupportedLanguageException();
        }
        return result;
    }
}
