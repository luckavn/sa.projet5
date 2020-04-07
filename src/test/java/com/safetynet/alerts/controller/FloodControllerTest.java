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
public class FloodControllerTest {

    @Autowired
    MockMvc mockmvc;

    @Autowired
    PersonDAO personDAO;

    @Test
    public void getFloodByStationNumber() throws Exception {
        String address = "?stations=1,4";
        this.mockmvc.perform(get("/flood/stations/" + address))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"address\":\"644 Gershwin Cir\",\"floodListFires\":[{\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"phone\":\"841-874-6512\",\"age\":20,\"medications\":[],\"allergies\":[\"shellfish\"]}]},{\"address\":\"489 Manchester St\",\"floodListFires\":[{\"firstName\":\"Lily\",\"lastName\":\"Cooper\",\"phone\":\"841-874-9845\",\"age\":26,\"medications\":[],\"allergies\":[]}]},{\"address\":\"908 73rd St\",\"floodListFires\":[{\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"phone\":\"841-874-8547\",\"age\":41,\"medications\":[\"thradox:700mg\"],\"allergies\":[\"illisoxian\"]},{\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"phone\":\"841-874-7462\",\"age\":38,\"medications\":[],\"allergies\":[]}]},{\"address\":\"112 Steppes Pl\",\"floodListFires\":[{\"firstName\":\"Tony\",\"lastName\":\"Cooper\",\"phone\":\"841-874-6874\",\"age\":26,\"medications\":[\"hydrapermazol:300mg\",\"dodoxadin:30mg\"],\"allergies\":[\"shellfish\"]},{\"firstName\":\"Ron\",\"lastName\":\"Peters\",\"phone\":\"841-874-8888\",\"age\":55,\"medications\":[],\"allergies\":[]},{\"firstName\":\"Allison\",\"lastName\":\"Boyd\",\"phone\":\"841-874-9888\",\"age\":55,\"medications\":[\"aznol:200mg\"],\"allergies\":[\"nillacilan\"]}]},{\"address\":\"947 E. Rose Dr\",\"floodListFires\":[{\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"phone\":\"841-874-7784\",\"age\":45,\"medications\":[\"ibupurin:200mg\",\"hydrapermazol:400mg\"],\"allergies\":[\"nillacilan\"]},{\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"phone\":\"841-874-7784\",\"age\":40,\"medications\":[],\"allergies\":[]},{\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"phone\":\"841-874-7784\",\"age\":6,\"medications\":[\"noxidian:100mg\",\"pharmacol:2500mg\"],\"allergies\":[]}]}]\n"))
                .andDo(MockMvcResultHandlers.print());
    }
}
