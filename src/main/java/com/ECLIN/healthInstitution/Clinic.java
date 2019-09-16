package com.ECLIN.healthInstitution;

import com.ECLIN.Patient;
import com.ECLIN.datamodel.DataModel;
import com.ECLIN.enums.ListType;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;

public class Clinic extends HealthInstitution {

    private DataModel doctorDataModel = new DataModel(institutionTriageType);
    private DataModel radiologyDataModel = new DataModel(institutionTriageType);

    public Clinic(TriageType triageType) {
        super(triageType);
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name, gravity, visibleSymptom);
        doctorDataModel.addNewPatientToList(newPatient);

        VisibleSymptom symptom = newPatient.getPatientVisibleSymptom();
        if (symptom == VisibleSymptom.BROKEN_BONE || symptom == VisibleSymptom.SPRAIN) {
            radiologyDataModel.addNewPatientToList(newPatient);
        }
    }

    public DataModel getDataModel(ListType listType) {
        if (listType == ListType.DOCTOR) {
            return doctorDataModel;
        }
        else return radiologyDataModel;
    }
}
