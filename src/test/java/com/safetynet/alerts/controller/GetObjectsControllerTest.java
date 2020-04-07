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
public class GetObjectsControllerTest {

    @Autowired
    MockMvc mockmvc;

    @Autowired
    PersonDAO personDAO;

    @Test
    public void getPersonListTest() throws Exception {
        this.mockmvc.perform(get("/list/ppl"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-6512\",\"email\":\"tenz@email.com\"},{\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-6544\",\"email\":\"jaboyd@email.com\"},{\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"address\":\"29 15th St\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"firstName\":\"Tessa\",\"lastName\":\"Carman\",\"address\":\"834 Binoc Ave\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-6512\",\"email\":\"tenz@email.com\"},{\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"address\":\"644 Gershwin Cir\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"firstName\":\"Foster\",\"lastName\":\"Shepard\",\"address\":\"748 Townings Dr\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-6544\",\"email\":\"jaboyd@email.com\"},{\"firstName\":\"Tony\",\"lastName\":\"Cooper\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-6874\",\"email\":\"tcoop@ymail.com\"},{\"firstName\":\"Lily\",\"lastName\":\"Cooper\",\"address\":\"489 Manchester St\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-9845\",\"email\":\"lily@email.com\"},{\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-7878\",\"email\":\"soph@email.com\"},{\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-7512\",\"email\":\"ward@email.com\"},{\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-7512\",\"email\":\"zarc@email.com\"},{\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"address\":\"908 73rd St\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-8547\",\"email\":\"reg@email.com\"},{\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"address\":\"908 73rd St\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-7462\",\"email\":\"jpeter@email.com\"},{\"firstName\":\"Ron\",\"lastName\":\"Peters\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-8888\",\"email\":\"jpeter@email.com\"},{\"firstName\":\"Allison\",\"lastName\":\"Boyd\",\"address\":\"112 Steppes Pl\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-9888\",\"email\":\"aly@imail.com\"},{\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-7784\",\"email\":\"bstel@email.com\"},{\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-7784\",\"email\":\"ssanw@email.com\"},{\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"address\":\"947 E. Rose Dr\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-7784\",\"email\":\"bstel@email.com\"},{\"firstName\":\"Clive\",\"lastName\":\"Ferguson\",\"address\":\"748 Townings Dr\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-6741\",\"email\":\"clivfd@ymail.com\"},{\"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"address\":\"951 LoneTree Rd\",\"city\":\"Culver\",\"zip\":97451,\"phone\":\"841-874-7458\",\"email\":\"gramps@email.com\"}]\n"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getMedicalRecordListTest() throws Exception {
        this.mockmvc.perform(get("/list/md"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"birthdate\":\"02/01/1984\",\"medications\":[\"aznol:350mg\",\"hydrapermazol:100mg\"],\"allergies\":[\"nillacilan\"]},{\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"birthdate\":\"02/01/1989\",\"medications\":[\"pharmacol:5000mg\",\"terazine:10mg\",\"noznazol:250mg\"],\"allergies\":[]},{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"birthdate\":\"02/01/2012\",\"medications\":[],\"allergies\":[\"peanut\"]},{\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"birthdate\":\"02/01/2017\",\"medications\":[],\"allergies\":[]},{\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"birthdate\":\"30/12/1986\",\"medications\":[\"tetracyclaz:650mg\"],\"allergies\":[\"xilliathal\"]},{\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"birthdate\":\"02/01/1989\",\"medications\":[],\"allergies\":[]},{\"firstName\":\"Tessa\",\"lastName\":\"Carman\",\"birthdate\":\"02/01/2012\",\"medications\":[],\"allergies\":[]},{\"firstName\":\"Peter\",\"lastName\":\"Duncan\",\"birthdate\":\"03/01/2000\",\"medications\":[],\"allergies\":[\"shellfish\"]},{\"firstName\":\"Foster\",\"lastName\":\"Shepard\",\"birthdate\":\"31/12/1980\",\"medications\":[],\"allergies\":[]},{\"firstName\":\"Tony\",\"lastName\":\"Cooper\",\"birthdate\":\"03/01/1994\",\"medications\":[\"hydrapermazol:300mg\",\"dodoxadin:30mg\"],\"allergies\":[\"shellfish\"]},{\"firstName\":\"Lily\",\"lastName\":\"Cooper\",\"birthdate\":\"03/01/1994\",\"medications\":[],\"allergies\":[]},{\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"birthdate\":\"04/01/1988\",\"medications\":[\"aznol:60mg\",\"hydrapermazol:900mg\",\"pharmacol:5000mg\",\"terazine:500mg\"],\"allergies\":[\"peanut\",\"shellfish\",\"aznol\"]},{\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"birthdate\":\"31/12/1985\",\"medications\":[],\"allergies\":[]},{\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"birthdate\":\"02/01/2017\",\"medications\":[],\"allergies\":[]},{\"firstName\":\"Reginold\",\"lastName\":\"Walker\",\"birthdate\":\"01/01/1979\",\"medications\":[\"thradox:700mg\"],\"allergies\":[\"illisoxian\"]},{\"firstName\":\"Jamie\",\"lastName\":\"Peters\",\"birthdate\":\"04/01/1982\",\"medications\":[],\"allergies\":[]},{\"firstName\":\"Ron\",\"lastName\":\"Peters\",\"birthdate\":\"04/01/1965\",\"medications\":[],\"allergies\":[]},{\"firstName\":\"Allison\",\"lastName\":\"Boyd\",\"birthdate\":\"04/01/1965\",\"medications\":[\"aznol:200mg\"],\"allergies\":[\"nillacilan\"]},{\"firstName\":\"Brian\",\"lastName\":\"Stelzer\",\"birthdate\":\"30/12/1975\",\"medications\":[\"ibupurin:200mg\",\"hydrapermazol:400mg\"],\"allergies\":[\"nillacilan\"]},{\"firstName\":\"Shawna\",\"lastName\":\"Stelzer\",\"birthdate\":\"31/12/1980\",\"medications\":[],\"allergies\":[]},{\"firstName\":\"Kendrik\",\"lastName\":\"Stelzer\",\"birthdate\":\"30/12/2014\",\"medications\":[\"noxidian:100mg\",\"pharmacol:2500mg\"],\"allergies\":[]},{\"firstName\":\"Clive\",\"lastName\":\"Ferguson\",\"birthdate\":\"03/01/1994\",\"medications\":[],\"allergies\":[]},{\"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"birthdate\":\"01/01/1945\",\"medications\":[\"tradoxidine:400mg\"],\"allergies\":[]}]\n"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getFireStationListTest() throws Exception {
        this.mockmvc.perform(get("/list/fs"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"address\":\"1509 Culver St\",\"station\":\"1000\"},{\"address\":\"834 Binoc Ave\",\"station\":\"3\"},{\"address\":\"644 Gershwin Cir\",\"station\":\"1\"},{\"address\":\"748 Townings Dr\",\"station\":\"3\"},{\"address\":\"112 Steppes Pl\",\"station\":\"3\"},{\"address\":\"489 Manchester St\",\"station\":\"4\"},{\"address\":\"908 73rd St\",\"station\":\"1\"},{\"address\":\"112 Steppes Pl\",\"station\":\"4\"},{\"address\":\"947 E. Rose Dr\",\"station\":\"1\"},{\"address\":\"748 Townings Dr\",\"station\":\"3\"},{\"address\":\"1509 Culver St\",\"station\":\"3\"}]\n"))
                .andDo(MockMvcResultHandlers.print());
    }
}
