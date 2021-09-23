package com.iagorubio.ioweb.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class AdminControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void adminRedirectLoginForm()  throws Exception {
        mvc.perform(get("/admin").contentType(MediaType.TEXT_HTML))
                .andExpect(status().isFound());
    }

    @Test
    void userDoLoginIntegrationOk()  throws Exception {
        mvc.perform(get("/admin").with(user("adm").password("pwd123").roles("ADMIN")).contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }

    @Test
    void userDoLoginIntegrationKo()  throws Exception {
        mvc.perform(get("/admin").with(user("user").password("pwd123").roles("USER")).contentType(MediaType.TEXT_HTML))
                .andExpect(status().is4xxClientError());
    }
}