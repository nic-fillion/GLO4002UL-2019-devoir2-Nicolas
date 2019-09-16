package com.ECLIN.datamodel;

import com.ECLIN.Patient;
import com.ECLIN.enums.TriageType;

import java.util.LinkedList;

public class DataModel {

    private LinkedList<Patient> patientList = new LinkedList<Patient>();
    private TriageType institutionTriageType;

    public DataModel(TriageType triageType) {
        setTriageType(triageType);
    }

    public TriageType getTriageType() {
        return institutionTriageType;
    }

    public void setTriageType(TriageType triageType) {
        institutionTriageType = triageType;
    }

    public void addNewPatientToList(Patient patient) {
        if (patient.getPatientGravity() > 1) {

            // sort with FIFO
            if (institutionTriageType == TriageType.FIFO) {
                patientList.addLast(patient);
            }

            // sort with GRAVITY
            else if (institutionTriageType == TriageType.GRAVITY) {
                if (patient.getPatientGravity() > 5) {
                    patientList.addFirst(patient);
                } else {
                    patientList.addLast(patient);
                }
            }
        }
    }

    public boolean listIsEmpty() {
        return patientList.size() == 0;
    }

    public int getListNumberOfPatient() {
        return patientList.size();
    }

    public Patient getFirstPatientOnList() {
        return patientList.removeFirst();
    }
}

