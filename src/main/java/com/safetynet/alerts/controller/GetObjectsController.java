package com.safetynet.alerts.controllers;

import com.safetynet.alerts.dao.FirestationDAO;
import com.safetynet.alerts.dao.MedicalRecordDAO;
import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class GetObjectsController {

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private MedicalRecordDAO medicalRecordDAO;
    @Autowired
    private FirestationDAO firestationDAO;

    @GetMapping("/ppl")
    public List<Person> getPerson() {
        return personDAO.getPersons();
    }

    @GetMapping("/md")
    public List<MedicalRecord> getMedicalRecord() {
        return medicalRecordDAO.getMedicalRecords();
    }

    @GetMapping("/fs")
    public List<FireStation> getFireStation() {
        return firestationDAO.getFireStations();
    }
}
