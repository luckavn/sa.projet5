package com.safetynet.alerts.utils;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Service
public class Utils {

    public int calculateAge(Date date) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date currentDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(date));
        int d2 = Integer.parseInt(formatter.format(currentDate));
        return (d2 - d1) / 10000;
    }

    public boolean resolveMinorPeopleFromAge(Integer age) throws ParseException {
        if (age <= 18) {
            return true;
        } else {
            return false;
        }
    }

    public boolean resolveMinorPeopleFromDate(Date date) throws ParseException {
        int age = calculateAge(date);
        boolean isMinor;
        if (resolveMinorPeopleFromAge(age)) isMinor = true;
        else isMinor = false;
        return isMinor;
    }
}
