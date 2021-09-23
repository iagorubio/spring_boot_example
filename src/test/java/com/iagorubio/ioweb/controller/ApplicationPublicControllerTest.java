package com.iagorubio.ioweb.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationPublicControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void publicServeTest()  throws Exception {
        mvc.perform(get("/public").contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }

    @Test
    void publicServeTestWithName()  throws Exception {
        MvcResult result = mvc.perform(get("/public").param("name", "XXX").contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andReturn();
        String s = new String(result.getResponse().getContentAsByteArray());
        assertTrue(s.contains("XXX"));
    }
}