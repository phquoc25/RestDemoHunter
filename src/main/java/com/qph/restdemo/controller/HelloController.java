package com.qph.restdemo.controller;

import com.qph.restdemo.service.exceptions.UnsupportedLanguageException;

/**
 * Created by Admin on 8/8/2016.
 */
public interface HelloController {
    String sayHello(String name, String language) throws UnsupportedLanguageException;
}
