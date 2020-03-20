package com.safetynet.alerts;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.model.Objects;

import java.io.File;
import java.io.IOException;

public class AlertsObjectMapper {

    public static void main(String[] args) {

        /** Initialize mapper */
        Objects objects = null;
        ObjectMapper mapper = new ObjectMapper();

        /** Read object from file and populate Person model */
        try {
            objects = mapper.readValue(new File("src/main/resources/data.json"), Objects.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(objects);
    }
}