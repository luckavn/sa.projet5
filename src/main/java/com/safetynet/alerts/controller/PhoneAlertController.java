package com.safetynet.alerts.controllers;

import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneAlertController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/phoneAlert")
    public List<Phone> getPhonesByStation(@RequestParam(name = "station") String station) throws Exception {
        if (station.isEmpty()) {
            throw new Exception("station value should be informed as parameter");
        } else {
            return personDAO.getPhoneByStation(station);
        }
    }
}