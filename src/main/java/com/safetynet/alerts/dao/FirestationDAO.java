package com.safetynet.alerts.dao;

import com.safetynet.alerts.model.Person;

import java.text.ParseException;
import java.util.List;

public interface PersonDAO {

    List<Person> getPersons();

    void addPerson(Person person);

    void modifyPerson(Person person) throws ParseException;

    boolean removePerson(String firstName, String lastName);

    List<String> getPersonInfoAndDetails(String firstName, String lastName) throws ParseException;

    List<String> getCityEmails(String city);

    List<String> getPhonesByStation(Integer station);

}

