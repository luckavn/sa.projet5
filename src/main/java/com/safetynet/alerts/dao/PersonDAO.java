package com.safetynet.alerts.dao;

import com.safetynet.alerts.model.*;
import com.safetynet.alerts.model.url.*;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

@Component
public interface PersonDAO {
    List<Person> getPersons();

    String addPerson(Person person);

    String modifyPerson(Person person) throws ParseException;

    String removePerson(String firstName, String lastName);

    List<Person> findPersonByLastNameFirstName(String lastName, String firstName);

    List<Person> findPersonsByLastName(String lastName);

    List<Person> findPersonsByStationAddress(String address);

    List<Person> findPersonsByStationNumber(String station);

    List<Person> findHouseholdMembers(String firstName, String lastName);

    List<List<PersonInfo>> getPersonInfoAndDetails(String lastName, String firstName) throws ParseException;

    List<Flood> getFloodByStationNumber(List<String> list);

    List<Email> getCityEmails(String city);

    List<Phone> getPhoneByStation(String station);

    List<ChildInfo> getChildListFromAddress(String address) throws ParseException;

    List<PersonListFire> getInhabitantsAndStationFromAddress(String address) throws ParseException;

    List<FloodListFire> getFloodListFireFromMedicalRecords(List<MedicalRecord> medicalRecordList);

}

