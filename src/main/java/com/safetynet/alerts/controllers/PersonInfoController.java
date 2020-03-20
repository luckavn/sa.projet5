//package com.safetynet.alerts.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/personInfo")
//public class PersonInfoController {
//
//    @Autowired
//    private PersonDAOImpl PersonDAOImpl;
//
//    @GetMapping("/firstName={firstName}+lastName={lastName}")
//    public PersonInfo read(@PathVariable String firstName lastName) {
//        return PersonDAOImpl.getPersonInfo(firstName, lastName);
//    }