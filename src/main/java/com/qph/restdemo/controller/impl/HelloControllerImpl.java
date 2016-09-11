package com.qph.restdemo.controller.impl;

import com.qph.restdemo.controller.HelloController;
import com.qph.restdemo.service.HelloService;
import com.qph.restdemo.service.exceptions.UnsupportedLanguageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by quocphan on 8/14/2016.
 */
@RestController
@RequestMapping("/admin")
public class HelloControllerImpl implements HelloController{

    private HelloService helloService;
    @Autowired
    public HelloControllerImpl(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    @RequestMapping(value = "/sayhello", method = RequestMethod.GET)
    public String sayHello(@RequestParam String name, @RequestParam String language) throws UnsupportedLanguageException {
        return helloService.sayHello(name, language);
    }

    @RequestMapping(value = "/sayhelloadd", method = RequestMethod.GET)
    public String sayHelloAdd(@RequestParam String name, @RequestParam String language, @RequestParam String add)
            throws UnsupportedLanguageException {
        System.out.println("Additional api " + add);
        return helloService.sayHello(name, language);
    }

}
