package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.FirestationDAO;
import com.safetynet.alerts.dao.MedicalRecordDAO;
import com.safetynet.alerts.dao.PersonDAO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class GetObjectsController {
    private static final Logger logger = LogManager.getLogger(GetObjectsController.class);

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private MedicalRecordDAO medicalRecordDAO;
    @Autowired
    private FirestationDAO firestationDAO;

    @GetMapping("/ppl")
    public List<Person> getPersonList() {
        logger.info("Get all person list succeeded");
        return personDAO.getPersons();
    }

    @GetMapping("/md")
    public List<MedicalRecord> getMedicalRecordList() {
        logger.info("Get all medical record list succeeded");
        return medicalRecordDAO.getMedicalRecords();
    }

    @GetMapping("/fs")
    public List<FireStation> getFireStationList() {
        logger.info("Get all firestation list succeeded");
        return firestationDAO.getFireStations();
    }

}
