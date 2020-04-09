package com.safetynet.alerts.dao;

import com.safetynet.alerts.AlertsObjectMapper;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.MedicalRecord;
import com.safetynet.alerts.model.Objects;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.url.*;
import com.safetynet.alerts.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private Utils utils;
    @Autowired
    private FirestationDAO firestationDAO;
    @Autowired
    private MedicalRecordDAO medicalRecordDAO;

    Objects objects = AlertsObjectMapper.readDataObjects();
    List<Person> persons = objects.getPersons();
    List<MedicalRecord> medicalRecords = objects.getMedicalrecords();
    List<FireStation> fireStations = objects.getFirestations();

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public String addPerson(Person person) {
        persons.add(person);
        return "Person added ! :)";
    }

    @Override
    public String modifyPerson(Person person) {
        int pos = 0;

        for (Person ps : persons) {
            if (ps.getFirstName().contentEquals(person.getFirstName()) && ps.getLastName().contentEquals(person.getLastName())) {
                persons.set(pos, person);
            }
            pos++;
            return "Modified person: " + person.getFirstName() + " " + person.getLastName();
        }
        return "Person not found";
    }

    @Override
    public String removePerson(String firstName, String lastName) {
        for (Person person : persons) {
            if (person.getFirstName().contentEquals(firstName) && person.getLastName().contentEquals(lastName)) {
                persons.remove(person);
                return "Deleted person: " + person.getFirstName() + " " + person.getLastName();
            }
        }
        return "Person not found";
    }

    @Override
    public List<Person> findPersonByLastNameFirstName(String lastName, String firstName) {
        List<Person> foundPerson = new ArrayList<Person>();

        for (Person person : persons) {
            if (person.getLastName().equals(lastName) && person.getFirstName().equals(firstName)) {
                foundPerson.add(person);
                return foundPerson;
            }
        }
        return foundPerson;
    }

    @Override
    public List<Person> findPersonsByLastName(String lastName) {
        List<Person> foundPersons = new ArrayList<Person>();

        for (Person person : persons) {
            if (person.getLastName().equals(lastName)) {
                foundPersons.add(person);
            }
        }
        return foundPersons;
    }

    @Override
    public List<Person> findPersonsByStationAddress(String address) {
        List<Person> foundPersonsByAddress = new ArrayList<Person>();

        for (FireStation fireStation : fireStations) {
            if (fireStation.getAddress().equals(address)) {
                for (Person person : persons) {
                    if (person.getAddress().equals(fireStation.getAddress())) {
                        foundPersonsByAddress.add(person);
                    }
                }
            }
        }
        return foundPersonsByAddress;
    }

    @Override
    public List<Person> findPersonsByStationNumber(String station) {
        List<Person> foundPersonsByNumber = new ArrayList<Person>();

        for (FireStation fireStation : fireStations) {
            if (fireStation.getStation().contentEquals(station)) {
                String stationAddress = fireStation.getAddress();
                for (Person person : persons) {
                    if (person.getAddress().equals(stationAddress)) {
                        foundPersonsByNumber.add(person);
                    }
                }
            }
        }
        return foundPersonsByNumber;
    }

    @Override
    public List<Person> findHouseholdMembers(String firstName, String lastName) {
        List<Person> householdMembers = new ArrayList<>();

        for (Person person : persons) {
            if (person.getLastName().contentEquals(lastName) && !person.getFirstName().contentEquals(firstName)) {
                householdMembers.add(person);
            }
        }
        return householdMembers;
    }

    @Override
    public List<List<PersonInfo>> getPersonInfoAndDetails(String lastName, String firstName) throws ParseException {
        List<List<PersonInfo>> result = new ArrayList<List<PersonInfo>>();
        List<Person> foundPersons;

        if (firstName != null) {
            foundPersons = findPersonByLastNameFirstName(lastName, firstName);
        } else {
            foundPersons = findPersonsByLastName(lastName);
        }

        for (Person person : foundPersons) {
            PersonInfo personInfo = new PersonInfo();
            List<PersonInfo> personInfos = new ArrayList<PersonInfo>();
            personInfo.setLastName(person.getLastName());
            personInfo.setAddress(person.getAddress());
            personInfo.setEmail(person.getEmail());

            for (MedicalRecord medicalRecord : medicalRecords) {
                if (medicalRecord.getFirstName().contentEquals(person.getFirstName()) && medicalRecord.getLastName().contentEquals(person.getLastName())) {
                    int agePerson = utils.calculateAge(medicalRecord.getBirthdate());
                    personInfo.setAge(agePerson);
                    personInfo.setMedications(medicalRecord.getMedications());
                    personInfo.setAllergies(medicalRecord.getAllergies());
                    personInfos.add(personInfo);
                }
            }
            result.add(personInfos);
        }
        return result;
    }

    @Override
    public List<Email> getCityEmails(String city) {
        List<Email> result = new ArrayList<Email>();
        List<String> emails = new ArrayList<String>();

        for (Person person : persons) {
            if (person.getCity().contentEquals(city)) {
                if (!emails.contains(person.getEmail())) {
                    emails.add(person.getEmail());
                    Email email = new Email(person.getEmail());
                    result.add(email);
                }
            }
        }
        return result;
    }

    @Override
    public List<Phone> getPhoneByStation(String station) {
        List<Phone> result = new ArrayList<Phone>();
        List<String> phones = new ArrayList<String>();

        for (FireStation fireStation : fireStations) {
            if (fireStation.getStation().contentEquals(station)) {
                String stationAddress = fireStation.getAddress();
                for (Person person : persons) {
                    if (person.getAddress().contentEquals(stationAddress)) {
                        if (!phones.contains(person.getPhone())) {
                            phones.add(person.getPhone());
                            Phone phone = new Phone(person.getPhone());
                            result.add(phone);
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<ChildInfo> getChildListFromAddress(String address) throws ParseException {
        List<ChildInfo> result = new ArrayList<ChildInfo>();

        for (Person person : persons) {
            if (person.getAddress().contentEquals(address)) {
                for (MedicalRecord medicalRecord : medicalRecords) {
                    if (medicalRecord.getFirstName().contentEquals(person.getFirstName()) && medicalRecord.getLastName().contentEquals(person.getLastName())) {
                        boolean medicalPersonMinor = utils.resolveMinorPeopleFromDate(medicalRecord.getBirthdate());
                        if (medicalPersonMinor) {
                            ChildInfo childInfo = new ChildInfo();
                            childInfo.setFirstName(medicalRecord.getFirstName());
                            childInfo.setLastName(medicalRecord.getLastName());
                            int agePerson = utils.calculateAge(medicalRecord.getBirthdate());
                            childInfo.setAge(agePerson);
                            List<Person> householdMembers = findHouseholdMembers(childInfo.getFirstName(), childInfo.getLastName());
                            childInfo.setHouseholdMembers(householdMembers);
                            result.add(childInfo);
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<Flood> getFloodByStationNumber(List<String> list) {
        List<Flood> result = new ArrayList<>();
        List<String> addresses = firestationDAO.resolveAddressesByStationNumber(list);

        for (String address : addresses) {
            Flood flood = new Flood();
            flood.setAddress(address);
            List<MedicalRecord> medicalRecordList = medicalRecordDAO.getMedicalRecordsFromAddress(address);
            List<FloodListFire> floodListFireList = getFloodListFireFromMedicalRecords(medicalRecordList);
            flood.setFloodListFires(floodListFireList);
            result.add(flood);
        }
        return result;
    }


    @Override
    public List<PersonListFire> getInhabitantsAndStationFromAddress(String address) throws ParseException {
        List<PersonListFire> result = new ArrayList<PersonListFire>();
        List<Person> foundPersons = findPersonsByStationAddress(address);
        String stationNumber = firestationDAO.findStationNumberByAddress(address);

        for (Person person : foundPersons) {
            PersonListFire personListFire = new PersonListFire();
            personListFire.setFirstName(person.getFirstName());
            personListFire.setLastName(person.getLastName());
            personListFire.setPhone(person.getPhone());
            personListFire.setStation(stationNumber);

            for (MedicalRecord medicalRecord : medicalRecords) {
                if (medicalRecord.getFirstName().contentEquals(person.getFirstName()) && medicalRecord.getLastName().contentEquals(person.getLastName())) {
                    int agePerson = utils.calculateAge(medicalRecord.getBirthdate());
                    personListFire.setAge(agePerson);
                    personListFire.setMedications(medicalRecord.getMedications());
                    personListFire.setAllergies(medicalRecord.getAllergies());
                    result.add(personListFire);
                }
            }
        }
        return result;
    }

    @Override
    public List<FloodListFire> getFloodListFireFromMedicalRecords(List<MedicalRecord> medicalRecordList) {
        List<FloodListFire> floodListFireList = new ArrayList<>();

        for (MedicalRecord medicalRecord : medicalRecordList) {
            FloodListFire floodListFire = new FloodListFire();
            floodListFire.setFirstName(medicalRecord.getFirstName());
            floodListFire.setLastName(medicalRecord.getLastName());
            floodListFire.setAge(utils.calculateAge(medicalRecord.getBirthdate()));
            floodListFire.setAllergies(medicalRecord.getAllergies());
            floodListFire.setMedications(medicalRecord.getMedications());
            for (Person person : persons) {
                if (person.getFirstName().contentEquals(medicalRecord.getFirstName()) && person.getLastName().contentEquals(medicalRecord.getLastName())) {
                    floodListFire.setPhone(person.getPhone());
                    floodListFireList.add(floodListFire);
                }
            }
        }
        return floodListFireList;
    }
}


