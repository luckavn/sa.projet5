package com.safetynet.alerts.model;

public class Phone {

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Phone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
