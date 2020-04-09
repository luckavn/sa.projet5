package com.safetynet.alerts.dao;

import com.safetynet.alerts.AlertsObjectMapper;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Objects;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class MedicalRecordDAOImpl implements MedicalRecordDAO {

    @Autowired
    private Utils utils;

    Objects objects = AlertsObjectMapper.readDataObjects();
    List<MedicalRecord> medicalRecords = objects.getMedicalrecords();
    List<Person> persons = objects.getPersons();

    @Override
    public MedicalRecord findMinor() throws ParseException {
        MedicalRecord medicalRecordMinor = new MedicalRecord();

        for (MedicalRecord medicalRecord : medicalRecords) {
            boolean isMinor = utils.resolveMinorPeopleFromDate(medicalRecord.getBirthdate());
            if (isMinor) {
                medicalRecordMinor.setFirstName(medicalRecord.getFirstName());
                medicalRecordMinor.setLastName(medicalRecord.getLastName());
                medicalRecordMinor.setBirthdate(medicalRecord.getBirthdate());
                return medicalRecordMinor;
            }
        }
        return null;
    }

    @Override
    public int countAdultFromList(List<Person> coveredPersons) throws ParseException {
        int adultCount = 0;

        for (Person person : coveredPersons) {
            for (MedicalRecord medicalRecord : medicalRecords) {
                if (medicalRecord.getFirstName().contentEquals(person.getFirstName()) && medicalRecord.getLastName().contentEquals(person.getLastName())) {
                    boolean isMinor = utils.resolveMinorPeopleFromDate(medicalRecord.getBirthdate());
                    if (!isMinor) {
                        adultCount++;
                    }
                }
            }
        }
        return adultCount;
    }

    @Override
    public int countChildFromList(List<Person> coveredPersons) throws ParseException {
        int childCount = 0;

            for (Person person : coveredPersons) {
                for (MedicalRecord medicalRecord : medicalRecords) {
                    if (medicalRecord.getFirstName().contentEquals(person.getFirstName()) && medicalRecord.getLastName().contentEquals(person.getLastName())) {
                        boolean isMinor = utils.resolveMinorPeopleFromDate(medicalRecord.getBirthdate());
                        if (isMinor) {
                             childCount++;
                        }
                    }
                }
            }
            return childCount;
        }

    @Override
    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    @Override
    public List<MedicalRecord> getMedicalRecordsFromAddress(String address) {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();

        for (Person person : persons) {
            if (person.getAddress().contentEquals(address)) {
                for (MedicalRecord medicalRecord : medicalRecords) {
                    if (medicalRecord.getFirstName().contentEquals(person.getFirstName()) && medicalRecord.getLastName().contentEquals(person.getLastName())) {
                        medicalRecordList.add(medicalRecord);
                    }
                }
            }
        }
        return medicalRecordList;
    }



    @Override
    public String addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
        return "Medical record added ! :)";
    }

    @Override
    public String removeMedicalRecord(String firstName, String lastName) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getFirstName().contentEquals(firstName) && medicalRecord.getLastName().contentEquals(lastName)) {
                medicalRecords.remove(medicalRecord);
                return "Medical record deleted: " + medicalRecord.getFirstName() + " " + medicalRecord.getLastName();
            }
        }
        return "Medical record not found";
    }

    @Override
    public String modifyMedicalRecord(MedicalRecord medicalRecord) {
        int pos = 0;

        for (MedicalRecord md : medicalRecords) {
            if (md.getFirstName().contentEquals(medicalRecord.getFirstName()) && md.getLastName().contentEquals(medicalRecord.getLastName())) {
                medicalRecords.set(pos, medicalRecord);
            }
            pos++;
            return "Modified medical record : " + medicalRecord.getFirstName() + " " + medicalRecord.getLastName();
        }
        return "Medical record not found";
    }
}

