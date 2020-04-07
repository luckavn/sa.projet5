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
public class PhoneAlertControllerTest {

    @Autowired
    MockMvc mockmvc;

    @Autowired
    PersonDAO personDAO;

    @Test
    public void getPhonesByStationTest() throws Exception {
        String station = "?station=1";
        this.mockmvc.perform(get("/phoneAlert" + station))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"phone\":\"841-874-6512\"},{\"phone\":\"841-874-8547\"},{\"phone\":\"841-874-7462\"},{\"phone\":\"841-874-7784\"}]"))
                .andDo(MockMvcResultHandlers.print());
    }
}
