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
public class MedicalRecordControllerTest {

    @Autowired
    MockMvc mockmvc;

    @Autowired
    PersonDAO personDAO;

    @Test
    public void addMedicalRecordTest() throws Exception {
        this.mockmvc.perform(post("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\":\"Lucas\",\"Vannier\":\"Boyd\",\"birthdate\":\"01/12/1992\",\"medications\":[\"aznol:3500mg\",\"hydrapermazol:10000mg\"],\"allergies\":[\"nillacilan\"]}\n"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void modifyMedicalRecordTest() throws Exception {
        this.mockmvc.perform(put("/medicalRecord").contentType(MediaType.APPLICATION_JSON).content("{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"birthdate\":\"02/18/2012\",\"medications\":[],\"allergies\":[\"modified line\"]}\n"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void removeMedicalRecordTest() throws Exception {
        String firstnameLastname = "?firstname=Jacob&lastname=Boyd";
        this.mockmvc.perform(delete("/medicalRecord" + firstnameLastname))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
