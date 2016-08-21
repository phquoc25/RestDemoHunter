package com.qph.restdemo.service.impl;

import com.qph.restdemo.service.HelloService;
import com.qph.restdemo.service.LanguageHandler;
import com.qph.restdemo.service.exceptions.UnsupportedLanguageException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quocphan on 8/21/2016.
 */
public class HelloServiceImplTest extends ServiceTest {
    @Mock
    private EnHelloHandler enHelloHandlerMock;
    @Mock
    private FrHelloHandler frHelloHandlerMock;

    @Spy
    private List<LanguageHandler> languageHandlers = new ArrayList<LanguageHandler>();

    @Autowired
    @InjectMocks
    private HelloService helloService;

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting up test case");
        MockitoAnnotations.initMocks(this);
        languageHandlers.add(frHelloHandlerMock);
        languageHandlers.add(enHelloHandlerMock);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSayHelloEn() throws Exception {
        String name = "Quoc";
        String language = "en";
        String expectedResult = "Hello Quoc";
        //Mock the methods
        Mockito.when(enHelloHandlerMock.isSupported(language)).thenReturn(true);
        Mockito.when(enHelloHandlerMock.sayHello(name)).thenReturn(expectedResult);
        Mockito.when(frHelloHandlerMock.isSupported(language)).thenReturn(false);

        // Calling service test
        String result = helloService.sayHello(name, language);

        //Verifying the mocking methods
        Mockito.verify(frHelloHandlerMock, Mockito.times(1)).isSupported(language);
        Mockito.verify(frHelloHandlerMock, Mockito.never()).sayHello(name);
        Mockito.verify(enHelloHandlerMock, Mockito.times(1)).isSupported(language);
        Mockito.verify(enHelloHandlerMock, Mockito.times(1)).sayHello(name);

        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testSayHelloFr() throws Exception {
        String name = "Quoc";
        String language = "fr";
        String expectedResult = "Bonjour Quoc";
        //Mock the methods
        Mockito.when(frHelloHandlerMock.isSupported(language)).thenReturn(true);
        Mockito.when(frHelloHandlerMock.sayHello(name)).thenReturn(expectedResult);
        Mockito.when(enHelloHandlerMock.isSupported(language)).thenReturn(false);

        // Calling service test
        String result = helloService.sayHello(name, language);

        //Verifying the mocking methods
        Mockito.verify(frHelloHandlerMock, Mockito.times(1)).isSupported(language);
        Mockito.verify(frHelloHandlerMock, Mockito.times(1)).sayHello(name);
        Mockito.verify(enHelloHandlerMock, Mockito.never()).isSupported(language);
        Mockito.verify(enHelloHandlerMock, Mockito.never()).sayHello(name);

        Assert.assertEquals(expectedResult, result);
    }

    @Test(expected = UnsupportedLanguageException.class)
    public void testSayHelloUnsupportedLanguageShouldThrowUnsupportedLanguageException() throws Exception {
        String name = "Quoc";
        String language = "spa";
        //Mock the methods
        Mockito.when(frHelloHandlerMock.isSupported(language)).thenReturn(false);
        Mockito.when(enHelloHandlerMock.isSupported(language)).thenReturn(false);

        // Calling service test
        String result = helloService.sayHello(name, language);

        //Verifying the mocking methods
        Mockito.verify(frHelloHandlerMock, Mockito.times(1)).isSupported(language);
        Mockito.verify(frHelloHandlerMock, Mockito.never()).sayHello(name);
        Mockito.verify(enHelloHandlerMock, Mockito.times(1)).isSupported(language);
        Mockito.verify(enHelloHandlerMock, Mockito.never()).sayHello(name);
    }

}