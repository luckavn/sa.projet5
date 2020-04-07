package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.PersonDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    MockMvc mockmvc;

    @Autowired
    PersonDAO personDAO;

    @Test
    public void addPersonTest() throws Exception {
        this.mockmvc.perform(post("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\":\"Lucas\",\"lastName\":\"Vannier\",\"address\":\"71 boulevard Richard Wallace\",\"city\":\"Puteaux\",\"zip\":92800,\"phone\":\"0777281554\",\"email\":\"lucasvannier@gmail.com\"}\n"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void modifyPersonTest() throws Exception {
        this.mockmvc.perform(put("/person").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"Valeur remplacée\",\"city\":\"Valeur remplacée\",\"zip\":\"97451\",\"phone\":\"841-874-6512\",\"email\":\"Valeur remplacée\"}\n"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void removePersonTest() throws Exception {
        String firstnameLastname = "?firstname=Foster&lastname=Shepard";
        this.mockmvc.perform(delete("/person" + firstnameLastname))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.log());
    }
}
