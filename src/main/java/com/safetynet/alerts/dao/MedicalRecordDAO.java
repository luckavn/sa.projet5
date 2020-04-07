package com.safetynet.alerts.dao;

import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Person;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

@Component
public interface MedicalRecordDAO {
    MedicalRecord findMinor() throws ParseException;

    int countChildFromList(List<Person> coveredPersons) throws ParseException;

    int countAdultFromList(List<Person> coveredPersons) throws ParseException;

    List<MedicalRecord> getMedicalRecords();

    List<MedicalRecord> getMedicalRecordsFromAddress(String address);

    void addMedicalRecord(MedicalRecord medicalRecord);

    String modifyMedicalRecord(MedicalRecord medicalRecord);

    String removeMedicalRecord(String firstName, String lastName);


}