package com.safetynet.alerts.model.url;

import java.util.List;

public class FireStationCoverageAndCounter {
    List<FireStationCoverage> fireStationCoverages;
    int adultCount;
    int childCount;

    public List<FireStationCoverage> getFireStationCoverages() {
        return fireStationCoverages;
    }

    public void setFireStationCoverages(List<FireStationCoverage> fireStationCoverages) {
        this.fireStationCoverages = fireStationCoverages;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

}
