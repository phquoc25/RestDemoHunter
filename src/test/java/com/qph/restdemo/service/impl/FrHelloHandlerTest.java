package com.qph.restdemo.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by quocphan on 8/21/2016.
 */
public class FrHelloHandlerTest extends ServiceTest{
    public static final String HELLO_DEFAULT = "Bonjour invité";
    @Autowired
    private FrHelloHandler frHelloHandler;

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting up the test case");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Cleaning up the test case");
    }

    @Test
    public void testSayHello() throws Exception {
        String name = "Quoc";
        String result = frHelloHandler.sayHello(name);
        Assert.assertEquals("Bonjour Quoc", result);
    }

    @Test
    public void testSayHelloWhenNameEmptyShouldHelloGuest() throws Exception {
        String name = "";
        String result = frHelloHandler.sayHello(name);
        Assert.assertEquals(HELLO_DEFAULT, result);
        name = null;
        result = frHelloHandler.sayHello(name);
        Assert.assertEquals(HELLO_DEFAULT, result);
    }
}