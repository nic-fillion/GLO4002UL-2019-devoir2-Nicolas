package com.ECLIN.datamodel;

import com.ECLIN.Patient;
import com.ECLIN.enums.TriageType;

import java.util.LinkedList;

public class RadiologyDataModel implements DataModel {

    private LinkedList<Patient> radiologyList = new LinkedList<Patient>();
    private TriageType institutionTriageType = TriageType.FIFO;

    public RadiologyDataModel() {}

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
                radiologyList.addLast(patient);
            }

            // sort with GRAVITY
            else if (institutionTriageType == TriageType.GRAVITY) {
                if (patient.getPatientGravity() > 5) {
                    radiologyList.addFirst(patient);
                } else {
                    radiologyList.addLast(patient);
                }
            }
        }
    }

    public boolean listIsEmpty() {
        return radiologyList.size() == 0;
    }

    public int getListNumberOfPatient() {
        return radiologyList.size();
    }

    public Patient getFirstPatientOnList() {
        return radiologyList.removeFirst();
    }
}
