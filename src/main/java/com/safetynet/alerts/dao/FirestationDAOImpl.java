package com.safetynet.alerts.dao;

import com.safetynet.alerts.AlertsObjectMapper;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.url.FireStationCoverage;
import com.safetynet.alerts.model.Objects;
import com.safetynet.alerts.model.Person;
import com.safetynet.alerts.model.url.FireStationCoverageAndCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FirestationDAOImpl implements FirestationDAO {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private MedicalRecordDAO medicalRecordDAO;

    Objects objects = AlertsObjectMapper.readDataObjects();
    List<FireStation> fireStations = objects.getFirestations();

    @Override
    public String findStationNumberByAddress(String address) {
        String station = "";
        for (FireStation fireStation : fireStations) {
            if (fireStation.getAddress().contentEquals(address)) {
                station = fireStation.getStation();
            }
        }
        return station;
    }

    @Override
    public List<String> resolveAddressesByStationNumber(List<String> list) {
        List<String> addresses = new ArrayList<>();

        for (FireStation fireStation : fireStations) {
            if (list.contains(fireStation.getStation())) {
                addresses.add(fireStation.getAddress());
            }
        }
        return addresses;
    }


    @Override
    public FireStationCoverageAndCounter getPersonListCoveredByStation(String station) throws ParseException {
        FireStationCoverageAndCounter result2 = new FireStationCoverageAndCounter();
        List<FireStationCoverage> result = new ArrayList<>();
        List<Person> coveredPersons = personDAO.findPersonsByStationNumber(station);

        int adultCounter = medicalRecordDAO.countAdultFromList(coveredPersons);
        int childCounter = medicalRecordDAO.countChildFromList(coveredPersons);

        for (Person person : coveredPersons) {
                FireStationCoverage fireStationCoverage = new FireStationCoverage();
                fireStationCoverage.setFirstName(person.getFirstName());
                fireStationCoverage.setLastName(person.getLastName());
                fireStationCoverage.setAddress(person.getAddress());
                fireStationCoverage.setPhone(person.getPhone());
                result.add(fireStationCoverage);
        }
        result2.setFireStationCoverages(result);
        result2.setAdultCount(adultCounter);
        result2.setChildCount(childCounter);
        return result2;
    }

    @Override
    public List<FireStation> getFireStations() {
        return fireStations;
    }

    @Override
    public void addFireStation(FireStation fireStation) {
        fireStations.add(fireStation);
    }

    @Override
    public String modifyFireStation(FireStation fireStation) {
        int pos = 0;

        for (FireStation fs : fireStations) {
            if (fs.getAddress().contentEquals(fireStation.getAddress())) {
                fireStations.set(pos, fireStation);
            }
            return "Modified firestation: " + fireStation.getAddress();
        }
        return "Firestation not found";
    }

    @Override
    public String removeFireStationFromAddress(String address) {
        for (FireStation fireStation : fireStations) {
            if (fireStation.getAddress().contentEquals(address)) {
                fireStations.remove(fireStation);
                return "Firestation deleted: " + fireStation;
            }
        }
        return "Firesation not found";
    }

    @Override
    public String removeMultipleFireStations(String station) {
        List<FireStation> deletedFirestations = new ArrayList<>();

        for (FireStation fireStation : fireStations) {
            if (fireStation.getStation().contentEquals(station)) {
                if (!deletedFirestations.contains(fireStation)) {
                    deletedFirestations.add(fireStation);
                }
            }
        }
        if (deletedFirestations.size() == 0)
            return "No firestation found";
        fireStations.removeAll(deletedFirestations);
        return "Deleted firestations: " + deletedFirestations;
    }
}


