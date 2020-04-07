package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.model.url.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneAlertController {
    private static final Logger logger = LogManager.getLogger(PhoneAlertController.class);

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/phoneAlert")
    public List<Phone> getPhonesByStation(@RequestParam(name = "station") String station) throws Exception {
        if (station.isEmpty()) {
            logger.error("Station is not well informed");
            throw new Exception("station value should be informed as parameter");
        } else {
            logger.info("Get phones by station number succeeded");
            return personDAO.getPhoneByStation(station);
        }
    }

}