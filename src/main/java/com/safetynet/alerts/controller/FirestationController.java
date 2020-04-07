
package com.safetynet.alerts.controller;

import com.safetynet.alerts.dao.FirestationDAO;
import com.safetynet.alerts.model.FireStation;
import com.safetynet.alerts.model.url.FireStationCoverageAndCounter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/firestation")
public class FirestationController {
    private static final Logger logger = LogManager.getLogger(FirestationController.class);

    @Autowired
    private FirestationDAO firestationDAO;

    @GetMapping
    public FireStationCoverageAndCounter getPersonListCoveredByStation(@RequestParam("stationNumber") String station) throws Exception {
        if (station.isEmpty()) {
            logger.error("Station value is not well informed");
            throw new Exception("station value should be informed as parameter");
        }
        logger.info("Get person list covered by station succeeded");
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
    public String removeSingleFirestation(@RequestParam("address") String address) throws Exception {
        if (address.isEmpty()) {
            logger.error("Address value is not well informed");
            throw new Exception("address value should be informed as parameter");
        } else {
            logger.info("Remove single firestation succeeded");
            return firestationDAO.removeFireStationFromAddress(address);
        }
    }

    @DeleteMapping("/multiple")
    public String removeMultipleFirestations(@RequestParam("station") String station) throws Exception {
        if (station.isEmpty()) {
            logger.error("Station value is not well informed");
            throw new Exception("Station value should be informed as parameter");
        }
        logger.info("Remove multiple firestations succeeded");
        return firestationDAO.removeMultipleFireStations(station);
    }

}
