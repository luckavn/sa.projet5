package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.FirestationDAO;
import com.safetynet.alerts.model.FireStation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GetObjectsControllerTest {
    ResourceBundle myBundle = ResourceBundle.getBundle("TestResponses");

    @Autowired
    MockMvc mockmvc;

    @MockBean
    FirestationDAO firestationDAO;

    @Test
    public void getPersonListTest() throws Exception {
        this.mockmvc.perform(get("/list/ppl"))
                .andExpect(status().isOk())
                .andExpect(content().json(myBundle.getString("goct.ppl")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getMedicalRecordListTest() throws Exception {
        this.mockmvc.perform(get("/list/md"))
                .andExpect(status().isOk())
                .andExpect(content().json(myBundle.getString("goct.mdr")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getFireStationListTest() throws Exception {
        FireStation firestation1 = new FireStation();
        firestation1.setAddress("1 rue de Paris");
        firestation1.setStation("1");

        FireStation firestation2 = new FireStation();
        firestation2.setAddress("2 rue de Paris");
        firestation2.setStation("2");

        List<FireStation> responseExpected = new ArrayList<>();
        responseExpected.add(firestation1);
        responseExpected.add(firestation2);

        given(this.firestationDAO.getFireStations())
                .willReturn(responseExpected);

        this.mockmvc.perform(get("/list/fs"))
                .andExpect(status().isOk())
                .andExpect(content().json(myBundle.getString("goct.fs.unit")))
                .andDo(MockMvcResultHandlers.print());
    }
}
