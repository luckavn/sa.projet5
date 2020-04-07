package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.PersonDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FirestationControllerTest {

    @Autowired
    MockMvc mockmvc;

    @Autowired
    PersonDAO personDAO;

    @Test
    public void getInhabitantsAndStationFromAddressTest() throws Exception {
        String station = "?stationNumber=2";
        this.mockmvc.perform(get("/firestation" + station))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"fireStationCoverages\":[{\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"address\":\"29 15th St\",\"phone\":\"841-874-6513\"},{\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"phone\":\"841-874-7878\"},{\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"phone\":\"841-874-7512\"},{\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"phone\":\"841-874-7512\"},{\"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"address\":\"951 LoneTree Rd\",\"phone\":\"841-874-7458\"}],\"adultCount\":4,\"childCount\":1}\n"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void addFirestationTest() throws Exception {
        this.mockmvc.perform(post("/firestation").contentType(MediaType.APPLICATION_JSON).content("{\"address\":\"1509 Culver St\",\"station\":\"3\"}\n"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void modifyFirestationTest() throws Exception {
        this.mockmvc.perform(put("/firestation").contentType(MediaType.APPLICATION_JSON).content("{\"address\":\"1509 Culver St\",\"station\":1000}\n"))
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
