package com.safetynet.alerts.controllers;

import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.model.PersonListFire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class FireController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/fire")
    public List<PersonListFire> getInhabitantsAndStationFromAddress(@RequestParam("address") String address) throws Exception {
        if (address.isEmpty()) {
            throw new Exception("address value should be informed as parameter");
        } else {
            return personDAO.getInhabitantsAndStationFromAddress(address);
        }
    }
}