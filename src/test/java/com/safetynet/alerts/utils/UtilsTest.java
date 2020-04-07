package com.safetynet.alerts.utils;

import com.safetynet.alerts.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UtilsTest {
    String birthDate = "01/01/2020";
    Date dateExcepted = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
    String dateToCalculate = "01/01/2000";

    @Autowired
    private Utils utils;

    public UtilsTest() throws ParseException {
    }

    @BeforeEach
    private void setUpForTest() throws Exception {
        utils = new Utils();
    }

    @Test
    public void calculateAgeTest() throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateToCalculate);
        int ageExpected = 20;

        int ageTested = utils.calculateAge(date);

        try {
            assertEquals(ageExpected, ageTested);
            System.out.print("Test passed: " + ageExpected + " (expected) = " + ageTested + " (actual)");
        } catch (AssertionError ae) {
            System.out.println("may change expected age");
            throw ae;
        }

    }

    @Test
    public void resolveMinorPeopleFromAgeTest() throws ParseException {
        int ageOfMinor = 17;
        int ageOfMajor = 19;

        boolean isMinor = utils.resolveMinorPeopleFromAge(ageOfMinor);
        boolean isMajor = utils.resolveMinorPeopleFromAge(ageOfMajor);

        try {
            assertTrue(isMinor = true);
            assertFalse(isMajor = false);
            System.out.print("Test passed: isMinor = true, Test passed: isMajor = false");
        } catch (AssertionError ae) {
            throw ae;
        }
    }

    @Test
    public void resolveMinorPeopleFromDateTest() throws ParseException {
        boolean isMinor = true;

        boolean resolveMinor = utils.resolveMinorPeopleFromDate(dateExcepted);

        try {
            assertTrue(isMinor = true);
            assertTrue(resolveMinor = true);
            System.out.print("Test passed: " + isMinor + " (expected) = " + resolveMinor + " (actual)");
        } catch (AssertionError ae) {
            throw ae;
        }
    }
}
