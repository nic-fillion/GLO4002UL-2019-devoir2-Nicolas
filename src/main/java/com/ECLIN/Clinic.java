package com.ECLIN;

import java.util.LinkedList;
import java.util.List;

public class Clinic {
    private LinkedList<Patient> doctorList = new LinkedList<Patient>();
    private LinkedList<Patient> radiologyList = new LinkedList<Patient>();

    public Clinic() {}

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name, gravity, visibleSymptom);
        doctorList.addLast(newPatient);

        VisibleSymptom symptom = newPatient.getPatientVisibleSymptom();
        if (symptom == VisibleSymptom.BROKEN_BONE || symptom == VisibleSymptom.SPRAIN) {
            radiologyList.addLast(newPatient);
        }
    }

    public boolean doctorListIsEmpty() {
        return (doctorList.size() == 0);
    }

    public boolean radiologyListIsEmpty() {
        return (radiologyList.size() == 0);
    }

    public int getDoctorListNumberOfPatient() {
        return doctorList.size();
    }

    public int getRadiologyListNumberOfPatient() {
        return radiologyList.size();
    }

    public Patient getFirstPatient(ListType listType) {
        Patient nextPatient;
        if (listType == ListType.DOCTOR) {
            nextPatient = doctorList.removeFirst();
        }
        else {
            nextPatient = radiologyList.removeFirst();
        }
        return nextPatient;
    }
}
