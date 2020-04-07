package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.model.url.Email;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityEmailController {
    private static final Logger logger = LogManager.getLogger(CommunityEmailController.class);


    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/communityEmail")
    public List<Email> getCityEmails(@RequestParam("city") String city) throws Exception {
        if (city.isEmpty()) {
            logger.error("City value is not well informed");
            throw new Exception("city value should be informed as parameter");
        } else {
            logger.info("Get city emails succeedeed");
            return personDAO.getCityEmails(city);
        }
    }
}
