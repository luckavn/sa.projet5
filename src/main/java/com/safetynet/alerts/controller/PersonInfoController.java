package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.model.url.ChildInfo;
import com.safetynet.alerts.model.url.PersonInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonInfoController {
    private static final Logger logger = LogManager.getLogger(PersonInfoController.class);

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/personInfo")
    public List<List<PersonInfo>> getPersonInfoAndDetails(@RequestParam(name = "firstname", required = false) String firstName, @RequestParam(name = "lastname") String lastName) throws Exception {
        if (lastName.isEmpty()) {
            logger.error("Firstname and/or lastname are not well informed");
            throw new Exception("at least lastname value should be informed as parameter");
        } else {
            logger.info("Get person info and details succeeded");
            return personDAO.getPersonInfoAndDetails(lastName, firstName);
        }
    }

    @GetMapping("/childAlert")
    public List<ChildInfo> getChildListFromAddress(@RequestParam(name = "address") String address) throws Exception {
        if (address.isEmpty()) {
            logger.error("Address is not well informed");
            throw new Exception("at least address value should be informed as parameter");
        } else {
            logger.info("Get child list from address succeeded");
            return personDAO.getChildListFromAddress(address);
        }
    }

}
