package com.safetynet.alerts.dao;

import com.safetynet.alerts.model.Person;

import java.util.ArrayList;
import java.util.List;

public interface PersonDAO {

    List<Person> getAllPersonInfo();
    String getFirstAddress();

    }

