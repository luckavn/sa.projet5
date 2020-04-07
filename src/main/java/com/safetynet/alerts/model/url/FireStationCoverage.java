package com.safetynet.alerts.model;

public class FireStationCoverage {
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private int adults;
    private int childs;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAdultCounter() {
        return adults;
    }

    public void setAdultCounter(int adultCounter) {
        this.adults = adultCounter;
    }

    public int getChildCounter() {
        return childs;
    }

    public void setChildCounter(int childCounter) {
        this.childs = childCounter;
    }

    @Override
    public String toString() {
        return "FireStationCoverage{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", adultCounter=" + adults +
                ", childCounter=" + childs +
                '}';
    }
}
