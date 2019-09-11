package com.ECLIN;
import com.ECLIN.enums.ListType;
import com.ECLIN.enums.TriageType;

import java.util.LinkedList;

public class InstitutionDataModel {

    private LinkedList<Patient> doctorList = new LinkedList<Patient>();
    private LinkedList<Patient> radiologyList = new LinkedList<Patient>();
    private LinkedList<Patient> nurseList = new LinkedList<Patient>();
    private TriageType clinicTriageType = TriageType.FIFO;

    public InstitutionDataModel() {}

    public TriageType getClinicTriageType() {
        return clinicTriageType;
    }

    public void setInstitutionTriageType(TriageType triageType) {
        clinicTriageType = triageType;
    }

    public void addNewPatientToList(Patient patient, ListType listType) {
        if (patient.getPatientGravity() > 1) {

            // sort with FIFO
            if (clinicTriageType == TriageType.FIFO) {
                if (listType == ListType.DOCTOR) {
                    doctorList.addLast(patient);
                }
                else if (listType == ListType.RADIOLOGY) {
                    radiologyList.addLast(patient);
                }
                else if (listType == ListType.NURSE) {
                    nurseList.addLast(patient);
                }
            }

            // sort with GRAVITY
            else if (clinicTriageType == TriageType.GRAVITY) {
                if (listType == ListType.DOCTOR) {
                    if (patient.getPatientGravity() > 5) {
                        doctorList.addFirst(patient);
                    } else {
                        doctorList.addLast(patient);
                    }
                }
                else if (listType == ListType.RADIOLOGY) {
                    if (patient.getPatientGravity() > 5) {
                        radiologyList.addFirst(patient);
                    } else {
                        radiologyList.addLast(patient);
                    }
                }
                else if (listType == ListType.NURSE) {
                    if (patient.getPatientGravity() > 5) {
                        nurseList.addFirst(patient);
                    } else {
                        nurseList.addLast(patient);
                    }
                }
            }
        }
    }

    public boolean listIsEmpty(ListType listType) {
        boolean listIsEmpty = true;

        if (listType == ListType.DOCTOR) {
            listIsEmpty =  (doctorList.size() == 0);
        }
        else if (listType == ListType.RADIOLOGY){
            listIsEmpty =  (radiologyList.size() == 0);
        }
        else if (listType == ListType.NURSE){
            listIsEmpty =  (nurseList.size() == 0);
        }
        return listIsEmpty;
    }

    public int getListNumberOfPatient(ListType listType) {
        int numberOfPatient = 0;

        if (listType == ListType.DOCTOR) {
            numberOfPatient =  doctorList.size();
        }
        else if (listType == ListType.RADIOLOGY){
            numberOfPatient =  radiologyList.size();
        }
        else if (listType == ListType.NURSE){
            numberOfPatient =  nurseList.size();
        }
        return numberOfPatient;
    }

    public Patient getFirstPatientOnList(ListType listType) {
        Patient nextPatient;
        if (listType == ListType.DOCTOR) {
            nextPatient = doctorList.removeFirst();
        }
        else if (listType == ListType.RADIOLOGY){
            nextPatient = radiologyList.removeFirst();
        }
        else {
            nextPatient = nurseList.removeFirst();
        }
        return nextPatient;
    }

}
