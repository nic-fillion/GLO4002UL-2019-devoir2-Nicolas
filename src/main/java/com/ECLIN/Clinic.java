package com.ECLIN;

import com.ECLIN.enums.ListType;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;

public class Clinic {

    protected InstitutionDataModel dataModel = new InstitutionDataModel();

    public Clinic() {}

    public Clinic(TriageType triageType) {
        dataModel.setInstitutionTriageType(triageType);
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name, gravity, visibleSymptom);
        dataModel.addNewPatientToList(newPatient, ListType.DOCTOR);

        VisibleSymptom symptom = newPatient.getPatientVisibleSymptom();
        if (symptom == VisibleSymptom.BROKEN_BONE || symptom == VisibleSymptom.SPRAIN) {
            dataModel.addNewPatientToList(newPatient, ListType.RADIOLOGY);
        }
    }

    public boolean listIsEmpty(ListType listType) {
        return dataModel.listIsEmpty(listType);
    }

    public int getListNumberOfPatient(ListType listType) {
        return dataModel.getListNumberOfPatient(listType);
    }

    public Patient getFirstPatient(ListType listType) {
        return dataModel.getFirstPatientOnList(listType);
    }

    public TriageType getTriageType() {
        return dataModel.getClinicTriageType();
    }
}
