package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.MedicalRecordDAO;
import com.safetynet.alerts.model.MedicalRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {
    private static final Logger logger = LogManager.getLogger(MedicalRecordController.class);

    @Autowired
    private MedicalRecordDAO medicalRecordDAO;

    @PostMapping
    public void addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        logger.info("Add medical record succeeded");
        medicalRecordDAO.addMedicalRecord(medicalRecord);
    }

    @PutMapping
    public String modifyMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        logger.info("Modify medical record succeeded");
        return medicalRecordDAO.modifyMedicalRecord(medicalRecord);
    }

    @DeleteMapping
    public String removeMedicalRecord(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) throws Exception {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            logger.error("Firstname and lastname are not well informed");
            throw new Exception("Firstname and lastname should be informed as parameters");
        }
        logger.info("Remove medical record succeeded");
        return medicalRecordDAO.removeMedicalRecord(firstName, lastName);
    }

}
