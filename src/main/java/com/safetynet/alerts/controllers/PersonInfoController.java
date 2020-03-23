package com.safetynet.alerts.controllers;

import com.safetynet.alerts.dao.PersonDAOImpl;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personInfo")
public class PersonInfoController {

    @Autowired
    private PersonDAOImpl personDaoImpl;

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Person> getAllPersonInfo() {
        List<Person> result = personDaoImpl.getAllPersonInfo();
        return result;
    }

    @GetMapping(path="/john", produces = "application/json")
    @ResponseBody
    public String getJohnInfo() {
        String result = personDaoImpl.getFirstAddress();
        return result;
    }
}
