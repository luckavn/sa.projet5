package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.model.url.Flood;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FloodController {
    private static final Logger logger = LogManager.getLogger(FloodController.class);

    @Autowired
    PersonDAO personDAO;

    @GetMapping("/flood/stations")
    public List<Flood> getFloodByStationNumber(@RequestParam(name = "stations") List<String> list) throws Exception {
        if (list.isEmpty()) {
            logger.error("List of station is not well informed");
            throw new Exception("list of station should not be empty");
        } else {
            logger.info("Get flood by station number succeeded");
            return personDAO.getFloodByStationNumber(list);
        }
    }

}
