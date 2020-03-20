package com.safetynet.alerts.controllers;

import com.safetynet.alerts.dao.PersonDAOImpl;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonDAOImpl PersonDAOImpl;

    @GetMapping("/{id}")
    public Person read(@PathVariable String id) {
//      return PersonDAOImpl.find(id);
        return null;
    }
}
