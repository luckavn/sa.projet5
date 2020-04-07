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
public class FireControllerTest {

    @Autowired
    MockMvc mockmvc;

    @Autowired
    PersonDAO personDAO;

    @Test
    public void getInhabitantsAndStationFromAddressTest() throws Exception {
        String address = "?address=892 Downing Ct";
        this.mockmvc.perform(get("/fire" + address))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"lastName\":\"Zemicks\",\"phone\":\"841-874-7878\",\"age\":32,\"medications\":[\"aznol:60mg\",\"hydrapermazol:900mg\",\"pharmacol:5000mg\",\"terazine:500mg\"],\"allergies\":[\"peanut\",\"shellfish\",\"aznol\"],\"station\":\"2\"},{\"lastName\":\"Zemicks\",\"phone\":\"841-874-7512\",\"age\":35,\"medications\":[],\"allergies\":[],\"station\":\"2\"},{\"lastName\":\"Zemicks\",\"phone\":\"841-874-7512\",\"age\":3,\"medications\":[],\"allergies\":[],\"station\":\"2\"}]\n"))
                .andDo(MockMvcResultHandlers.print());
    }
}
