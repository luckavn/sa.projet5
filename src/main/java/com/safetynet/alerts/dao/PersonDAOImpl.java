package com.safetynet.alerts.dao;

import com.safetynet.alerts.AlertsObjectMapper;
import com.safetynet.alerts.model.Objects;
import com.safetynet.alerts.model.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAOImpl implements PersonDAO {
        Objects objects = AlertsObjectMapper.readData();
        List<Person> personList = objects.getPersons();

        @Override
        public List<Person> getAllPersonInfo() {
                return personList;
        }

        @Override
        public String getFirstAddress() {
                String firstIndex = personList.get(0).getAddress();
                return firstIndex;
        }


}


