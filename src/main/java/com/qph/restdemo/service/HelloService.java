package com.qph.restdemo.service;

import com.qph.restdemo.service.exceptions.UnsupportedLanguageException;

/**
 * Created by quocphan on 8/14/2016.
 */
public interface HelloService {
    String sayHello(String name, String language) throws UnsupportedLanguageException;
}
