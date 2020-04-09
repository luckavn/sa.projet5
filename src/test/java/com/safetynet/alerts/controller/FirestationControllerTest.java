package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.PersonDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ResourceBundle;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FirestationControllerTest {
    ResourceBundle myBundle = ResourceBundle.getBundle("TestResponses");

    @Autowired
    MockMvc mockmvc;

    @Autowired
    PersonDAO personDAO;

    @Test
    public void getInhabitantsAndStationFromAddressTest() throws Exception {
        String station = "?stationNumber=2";
        this.mockmvc.perform(get("/firestation" + station))
                .andExpect(status().isOk())
                .andExpect(content().json(myBundle.getString("fsct.gi")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void addFirestationTest() throws Exception {
        this.mockmvc.perform(post("/firestation").contentType(MediaType.APPLICATION_JSON).content(myBundle.getString("fsct.add")))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void modifyFirestationTest() throws Exception {
        this.mockmvc.perform(put("/firestation").contentType(MediaType.APPLICATION_JSON).content(myBundle.getString("fsct.md")))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void removeFirestationTest() throws Exception {
        String address = "?address=29 15th St";
        this.mockmvc.perform(delete("/firestation" + address))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void removeMultipleFirestationsTest() throws Exception {
        String station = "?station=2";
        this.mockmvc.perform(delete("/firestation/multiple" + station))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
