package com.ECLIN;

import com.ECLIN.enums.ListType;
import com.ECLIN.enums.VisibleSymptom;

public class Clinic {

    private ClinicDataModel dataModel = new ClinicDataModel();

    public Clinic() {}

    public Clinic(TriageType triageType) {
        dataModel.setClinicTriageType(triageType);
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
}
