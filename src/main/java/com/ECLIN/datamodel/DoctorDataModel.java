package com.ECLIN.datamodel;

import com.ECLIN.Patient;
import com.ECLIN.enums.TriageType;

import javax.xml.crypto.Data;
import java.util.LinkedList;

public class DoctorDataModel implements DataModel {

    private LinkedList<Patient> doctorList = new LinkedList<Patient>();
    private TriageType institutionTriageType = TriageType.FIFO;

    public DoctorDataModel() {}

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
                doctorList.addLast(patient);
            }

            // sort with GRAVITY
            else if (institutionTriageType == TriageType.GRAVITY) {
                if (patient.getPatientGravity() > 5) {
                        doctorList.addFirst(patient);
                } else {
                        doctorList.addLast(patient);
                }
            }
        }
    }

    public boolean listIsEmpty() {
        return doctorList.size() == 0;
    }

    public int getListNumberOfPatient() {
        return doctorList.size();
    }

    public Patient getFirstPatientOnList() {
        return doctorList.removeFirst();
    }
}
