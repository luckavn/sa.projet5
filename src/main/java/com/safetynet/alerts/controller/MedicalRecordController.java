package com.safetynet.alerts.controllers;

import com.safetynet.alerts.dao.MedicalRecordDAO;
import com.safetynet.alerts.dao.MedicalRecordDAOImpl;
import com.safetynet.alerts.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordDAO medicalRecordDAO;

    @PostMapping
    public void addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        medicalRecordDAO.addMedicalRecord(medicalRecord);
    }

    @PutMapping
    public String modifyMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordDAO.modifyMedicalRecord(medicalRecord);
    }

    @DeleteMapping
    public String removeMedicalRecord(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) throws Exception {
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new Exception("Firstname and lastname should be informed as parameters");
        }
        return medicalRecordDAO.removeMedicalRecord(firstName, lastName);
    }

}
