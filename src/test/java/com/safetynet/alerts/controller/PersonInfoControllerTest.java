package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.PersonDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ResourceBundle;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonInfoControllerTest {
    ResourceBundle myBundle = ResourceBundle.getBundle("TestResponses");

    @Autowired
    MockMvc mockmvc;

    @Autowired
    PersonDAO personDAO;

    @Test
    public void getPersonInfoAndDetailsWithFirstNameAndLastNameTest() throws Exception {
        String firstnameLastname = "?firstname=Brian&lastname=Stelzer";
        this.mockmvc.perform(get("/personInfo" + firstnameLastname))
                .andExpect(status().isOk())
                .andExpect(content().json(myBundle.getString("pict.gipfl")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getPersonInfoAndDetailsWithLastNameTest() throws Exception {
        String firstnameLastname = "?lastname=Stelzer";
        this.mockmvc.perform(get("/personInfo" + firstnameLastname))
                .andExpect(status().isOk())
                .andExpect(content().json(myBundle.getString("pict.gipl")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getChildListFromAddressTest() throws Exception {
        String address = "?address=908 73rd St";
        this.mockmvc.perform(get("/childAlert" + address))
                .andExpect(status().isOk())
                .andExpect(content().json("[]\n"))
                .andDo(MockMvcResultHandlers.print());
    }
}
