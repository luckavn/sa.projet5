package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/person")
public class PersonController {
    private static final Logger logger = LogManager.getLogger(PersonController.class);

    @Autowired
    private PersonDAO personDAO;

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        logger.info("Add person succeeded");
        personDAO.addPerson(person);
    }

    @PutMapping
    public String modifyPerson(@RequestBody Person person) throws ParseException {
        logger.info("Modify person succeeded");
        return personDAO.modifyPerson(person);
    }

    @DeleteMapping
    public String removePerson(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) throws Exception {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            logger.error("Firstname and lastname are not well informed");
            throw new Exception("Firstname and lastname should be informed as parameters");
        } else {
            logger.info("Remove person succeeded");
            return personDAO.removePerson(firstName, lastName);
        }
    }

}
