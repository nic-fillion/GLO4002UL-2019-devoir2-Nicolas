package com.ECLIN;

import com.ECLIN.datamodel.DataModel;
import com.ECLIN.datamodel.DoctorDataModel;
import com.ECLIN.datamodel.RadiologyDataModel;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;

public class Clinic extends HealthInstitution{

    private DoctorDataModel doctorDataModel = new DoctorDataModel();
    private RadiologyDataModel radiologyDataModel = new RadiologyDataModel();

    public Clinic() {}

    public Clinic(TriageType triageType) {

        doctorDataModel.setTriageType(triageType);
        radiologyDataModel.setTriageType(triageType);
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name, gravity, visibleSymptom);
        doctorDataModel.addNewPatientToList(newPatient);

        VisibleSymptom symptom = newPatient.getPatientVisibleSymptom();
        if (symptom == VisibleSymptom.BROKEN_BONE || symptom == VisibleSymptom.SPRAIN) {
            radiologyDataModel.addNewPatientToList(newPatient);
        }
    }
}
