package com.safetynet.alerts.model;

import com.safetynet.alerts.model.url.PersonInfo;

import java.util.List;

public class Objects {
    List<Person> persons;
    List<FireStation> firestations;
    List<MedicalRecord> medicalrecords;
    List<PersonInfo> personInfos;

    public List<PersonInfo> getPersonInfos() {
        return personInfos;
    }

    public void setPersonInfos(List<PersonInfo> personInfos) {
        this.personInfos = personInfos;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<FireStation> getFirestations() {
        return firestations;
    }

    public void setFirestations(List<FireStation> firestations) {
        this.firestations = firestations;
    }

    public List<MedicalRecord> getMedicalrecords() {
        return medicalrecords;
    }

    public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

}
