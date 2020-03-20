/*
package com.safetynet.alerts.controllers;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordsController {

    private final static Logger logger = ILoggerFactory.;

    @Autowired
    private MedicalRecordService MedicalRecordDAOImpl;

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> read(@PathVariable("id") Long id) {
    MedicalRecord foundMedicalRecord = service.read(id);
    if (foundMedicalRecord == null) {
        return ResponseEntity.notFound().build();
    } else {
        return ResponseEntity.ok(foundMedicalRecord);
    }
    }

    @PostMapping("/")
    public ResponseEntity<MedicalRecord> create(@RequestBody MedicalRecord medicalRecord) throws URISyntaxException {
        MedicalRecord createdMedicalRecord = service.create(medicalRecord);
        if (createdMedicalRecord == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdMedicalRecord.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdMedicalRecord);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecord> update(@RequestBody MedicalRecord medicalRecord, @PathVariable Long id) {
        MedicalRecord updatedMedicalRecord = service.update(id, medicalRecord);
        if (updatedMedicalRecord == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedMedicalRecord);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMedicalRecord(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
*/
