package com.ECLIN.healthInstitution;

import com.ECLIN.Patient;
import com.ECLIN.datamodel.DataModel;
import com.ECLIN.enums.ListType;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;

public class Clinic implements  HealthInstitution{

    private TriageType institutionTriageType;
    private DataModel doctorDataModel;
    private DataModel radiologyDataModel;

    public Clinic(TriageType triageType) {
        institutionTriageType = triageType;
        doctorDataModel = new DataModel(triageType);
        radiologyDataModel = new DataModel(triageType);
    }

    private void setTriageType(TriageType triageType) { institutionTriageType = triageType; }

    public TriageType getTriageType() { return institutionTriageType; }

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
