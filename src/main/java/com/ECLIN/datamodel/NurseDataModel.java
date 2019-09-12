package com.ECLIN.datamodel;

import com.ECLIN.Patient;
import com.ECLIN.enums.TriageType;

import java.util.LinkedList;

public class NurseDataModel implements DataModel {

    private LinkedList<Patient> nurseList = new LinkedList<Patient>();
    private TriageType institutionTriageType = TriageType.FIFO;

    public NurseDataModel() {}

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
                nurseList.addLast(patient);
            }

            // sort with GRAVITY
            else if (institutionTriageType == TriageType.GRAVITY) {
                if (patient.getPatientGravity() > 5) {
                    nurseList.addFirst(patient);
                } else {
                    nurseList.addLast(patient);
                }
            }
        }
    }

    public boolean listIsEmpty() {
        return nurseList.size() == 0;
    }

    public int getListNumberOfPatient() {
        return nurseList.size();
    }

    public Patient getFirstPatientOnList() {
        return nurseList.removeFirst();
    }
}
