package com.ECLIN;
import com.ECLIN.enums.ListType;
import java.util.LinkedList;

public class ClinicDataModel {

    private LinkedList<Patient> doctorList = new LinkedList<Patient>();
    private LinkedList<Patient> radiologyList = new LinkedList<Patient>();
    private TriageType clinicTriageType = TriageType.FIFO;

    public ClinicDataModel() {}

    public TriageType getClinicTriageType() {
        return clinicTriageType;
    }

    public void setClinicTriageType(TriageType triageType) {
        clinicTriageType = triageType;
    }

    public void addNewPatientToList(Patient patient, ListType listType) {
        // sort with FIFO
        if (clinicTriageType == TriageType.FIFO) {
            if (listType == ListType.DOCTOR) {
                doctorList.addLast(patient);
            }
            else if (listType == ListType.RADIOLOGY){
                radiologyList.addLast(patient);
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
            else if (listType == ListType.RADIOLOGY){
                if (patient.getPatientGravity() > 5) {
                    radiologyList.addFirst(patient);
                } else {
                    radiologyList.addLast(patient);
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
        return numberOfPatient;
    }

    public Patient getFirstPatientOnList(ListType listType) {
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
