package com.ECLIN;

import com.ECLIN.enums.VisibleSymptom;

public class Patient {

    private String patientName;
    private int patientGravity;
    private VisibleSymptom patientVisibleSymptom;

    public Patient(String name, int gravity, VisibleSymptom visibleSymptom) {
        patientName = name;
        patientGravity = gravity;
        patientVisibleSymptom = visibleSymptom;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientGravity() {
        return patientGravity;
    }

    public VisibleSymptom getPatientVisibleSymptom() {
        return patientVisibleSymptom;
    }
}
