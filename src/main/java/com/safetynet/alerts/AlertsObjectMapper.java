package com.safetynet.alerts;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.model.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class AlertsObjectMapper {
    private static final Logger logger = LogManager.getLogger("ObjectMapper");

    public static Objects readData() {

        /** Initialize mapper */
        Objects objects = null;
        ObjectMapper mapper = new ObjectMapper();

        /** Read object from file and populate Person model */
        try {
            objects = mapper.readValue(new File("src/main/resources/data.json"), Objects.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
            logger.error("Error parsing Json", e);
        } catch (JsonMappingException e) {
            e.printStackTrace();
            logger.error("Error mapping Json", e);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error input or output", e);
        }
        logger.info("Printed Json objects");
        return objects;
    }

}