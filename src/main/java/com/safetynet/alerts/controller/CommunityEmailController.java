package com.safetynet.alerts.controllers;

import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityEmailController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/communityEmail")
    public List<Email> getCityEmails(@RequestParam("city") String city) throws Exception {
        if (city.isEmpty()) {
            throw new Exception("city value should be informed as parameter");
        } else {
            return personDAO.getCityEmails(city);
        }
    }
}
