package com.qph.restdemo.service.impl;

import com.qph.restdemo.Application;
import com.qph.restdemo.service.HelloService;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.apache.batik.svggen.font.table.Table.name;
import static org.junit.Assert.*;

/**
 * Created by quocphan on 8/21/2016.
 */
public class EnHelloHandlerTest extends ServiceTest {
    @Autowired
    private EnHelloHandler enHelloHandler;
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
        String result = enHelloHandler.sayHello(name);
        Assert.assertEquals("Hello " + name, result);
    }

    @Test
    public void testSayHelloWhenNameIsEmptyShouldBeGuest() throws Exception {
        String name = "";
        String result = enHelloHandler.sayHello(name);
        Assert.assertEquals("Hello guest", result);
        name = null;
        result = enHelloHandler.sayHello(name);
        Assert.assertEquals("Hello guest", result);
    }

    @Test
    public void testStringRemoveEnd(){
        String strTobeRemoved = "Saigon, HCM, HCM, ";
        String result = StringUtils.removeEnd(strTobeRemoved, ", ");
        Assert.assertEquals("Saigon, HCM, HCM, ", strTobeRemoved);
        Assert.assertEquals("Saigon, HCM, HCM", result);
    }

}