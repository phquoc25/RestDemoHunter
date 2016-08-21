package com.qph.restdemo.controller.impl;

import com.qph.restdemo.Application;
import com.qph.restdemo.controller.HelloController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

/**
 * Created by quocphan on 8/21/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
public class HelloControllerImplTest {

    @Autowired
    private HelloController helloController;

    private MockMvc mockMvc;
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSayHelloAPI() throws Exception {
        String name = "Quoc";
        String language = "en";
        String expectedResult = "Hello Quoc";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/admin/sayhello")
                .param("name", name)
                .param("language", language))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String actualResult = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(expectedResult, actualResult);
    }

}