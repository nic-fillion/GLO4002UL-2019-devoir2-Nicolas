package com.ECLIN;

import static org.junit.Assert.*;

import com.ECLIN.enums.VisibleSymptom;
import org.junit.Test;

public class PatientTest {

    @Test
    public void afterInit_thenPatientMustHaveNameGravityAndSymptoms() {
        Patient patient = new Patient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertNotNull(patient.getPatientName());
        assertNotNull(patient.getPatientGravity());
        assertNotNull(patient.getPatientVisibleSymptom());
    }
}
