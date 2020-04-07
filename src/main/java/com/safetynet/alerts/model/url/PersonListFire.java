package com.safetynet.alerts.model;

import java.util.List;

public class PersonListFire {
    private String lastName;
    private String phone;
    private int age;
    private List<String> medications;
    private List<String> allergies;
    private String station;

    public PersonListFire(int age) {
        this.age = age;
    }

    public PersonListFire() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getMedications() {
        return medications;
    }

    public void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "PersonListFire{" +
                "lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", medications=" + medications +
                ", allergies=" + allergies +
                ", station=" + station +
                '}';
    }
}
