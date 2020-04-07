package com.safetynet.alerts.model.url;

import java.util.List;

public class Flood {
    String address;
    List<FloodListFire> floodListFires;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<FloodListFire> getFloodListFires() {
        return floodListFires;
    }

    public void setFloodListFires(List<FloodListFire> floodListFires) {
        this.floodListFires = floodListFires;
    }

}
