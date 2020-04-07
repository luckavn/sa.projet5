package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.PersonDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CommunityEmailControllerTest {

    @Autowired
    MockMvc mockmvc;

    @Autowired
    PersonDAO personDAO;

    @Test
    public void getCommunityEmailTest() throws Exception {
        String city = "?city=Culver";
        this.mockmvc.perform(get("/communityEmail" + city))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"email\":\"jaboyd@email.com\"},{\"email\":\"drk@email.com\"},{\"email\":\"tenz@email.com\"},{\"email\":\"tcoop@ymail.com\"},{\"email\":\"lily@email.com\"},{\"email\":\"soph@email.com\"},{\"email\":\"ward@email.com\"},{\"email\":\"zarc@email.com\"},{\"email\":\"reg@email.com\"},{\"email\":\"jpeter@email.com\"},{\"email\":\"aly@imail.com\"},{\"email\":\"bstel@email.com\"},{\"email\":\"ssanw@email.com\"},{\"email\":\"clivfd@ymail.com\"},{\"email\":\"gramps@email.com\"}]"))
                .andDo(MockMvcResultHandlers.print());
    }
}
