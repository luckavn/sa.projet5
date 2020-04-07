package com.safetynet.alerts.controllers;

import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.dao.PersonDAOImpl;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personDAO.addPerson(person);
    }

    @PutMapping
    public String modifyPerson(@RequestBody Person person) throws ParseException {
        return personDAO.modifyPerson(person);
    }

    @DeleteMapping
    public String removePerson(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) throws Exception {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new Exception("Firstname and lastname should be informed as parameters");
        } else {
            return personDAO.removePerson(firstName, lastName);
        }
    }
}
