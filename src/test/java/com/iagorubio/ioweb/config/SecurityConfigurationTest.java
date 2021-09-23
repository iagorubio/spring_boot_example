package com.iagorubio.ioweb.config;

import com.iagorubio.ioweb.controller.AdminController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
@EnableConfigurationProperties
class SecurityConfigurationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private DataSource dataSource;

    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/admin").with(user("adm").password("pwd123").roles("ADMIN")).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void givenAuthRequestOnPrivateService_shouldFail() throws Exception {
        mvc.perform(get("/admin").with(user("user").password("pwd123").roles("USER")).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}