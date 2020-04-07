package com.safetynet.alerts.controllers;

import com.safetynet.alerts.dao.FirestationDAO;
import com.safetynet.alerts.dao.FirestationDAOImpl;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.FireStationCoverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/firestation")
public class FirestationController {

    @Autowired
    private FirestationDAO firestationDAO;

    @GetMapping
    //TODO corriger String not recognized, throw exception directly
    public List<FireStationCoverage> getPersonListCoveredByStation(@RequestParam("stationNumber") String station) throws Exception {
        if (station.isEmpty()) {
            throw new Exception("station value should be informed as parameter");
        }
        return firestationDAO.getPersonListCoveredByStation(station);
    }

    @PostMapping
    public void addFirestation(@RequestBody FireStation fireStation) {
        firestationDAO.addFireStation(fireStation);
    }

    @PutMapping
    public String modifyFirestation(@RequestBody FireStation fireStation) {
        return firestationDAO.modifyFireStation(fireStation);
    }

    @DeleteMapping
    public String removeFirestationByAddress(@RequestParam("address") String address) throws Exception {
        if (address.isEmpty()) {
            throw new Exception("address value should be informed as parameter");
        } else {
            return firestationDAO.removeFireStationFromAddress(address);
        }
    }

    @DeleteMapping("/fromnumber")
    public String removeFirestationsByStationNumber(@RequestParam("station") String station) {
        return firestationDAO.removeFireStationsFromStationNumber(station);
    }

}
