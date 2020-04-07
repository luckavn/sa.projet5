package com.safetynet.alerts.controllers;

import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.dao.PersonDAOImpl;
import com.safetynet.alerts.model.ChildInfo;
import com.safetynet.alerts.model.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonInfoController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping("/personInfo")
    public List<List<PersonInfo>> getPersonInfoAndDetails(@RequestParam(name = "firstname", required = false) String firstName, @RequestParam(name = "lastname") String lastName) throws Exception {
        if (lastName.isEmpty()) {
            throw new Exception("at least lastname value should be informed as parameter");
        } else {
            return personDAO.getPersonInfoAndDetails(lastName, firstName);
        }
    }

    @GetMapping("/childAlert")
    //TODO prendre en compte le paramètre address dans la résolution de la méthode
    //TODO Supprimer l'itération infini sur la même personne et scanner l'ensemble des medicalRecords
    public List<ChildInfo> getChildListFromAddress(@RequestParam(name = "address") String address) throws Exception {
        if (address.isEmpty()) {
            throw new Exception("at least address value should be informed as parameter");
        } else {
            return personDAO.getChildListFromAddress(address);
        }
    }

}
