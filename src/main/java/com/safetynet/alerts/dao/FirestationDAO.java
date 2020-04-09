package com.safetynet.alerts.dao;

import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.url.FireStationCoverage;
import com.safetynet.alerts.model.url.FireStationCoverageAndCounter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

@Component
public interface FirestationDAO {

    String findStationNumberByAddress(String address);

    List<FireStation> getFireStations();

    FireStationCoverageAndCounter getPersonListCoveredByStation(String station) throws ParseException;

    String addFireStation(FireStation fireStation);

    String modifyFireStation(FireStation fireStation);

    String removeFireStationFromAddress(String address);

    String removeMultipleFireStations(String station);

    List<String> resolveAddressesByStationNumber(List<String> list);
}

