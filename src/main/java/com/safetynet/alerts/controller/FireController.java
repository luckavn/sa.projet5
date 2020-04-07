package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.model.url.PersonListFire;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class FireController {
    private static final Logger logger = LogManager.getLogger(FireController.class);

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/fire")
    public List<PersonListFire> getInhabitantsAndStationFromAddress(@RequestParam("address") String address) throws Exception {
        if (address.isEmpty()) {
            logger.error("Address value is not well informed");
            throw new Exception("address value should be informed as parameter");
        } else {
            logger.info("Get inhabitants and station from address succeeded");
            return personDAO.getInhabitantsAndStationFromAddress(address);
        }
    }
}