package com.ECLIN.healthInstitution;

import com.ECLIN.Patient;
import com.ECLIN.datamodel.NurseDataModel;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;
import com.ECLIN.healthInstitution.HealthInstitution;

public class CommunityCenter extends HealthInstitution {

    private NurseDataModel nurseDataModel = new NurseDataModel();

    public CommunityCenter() {}

    public CommunityCenter(TriageType triageType) {
        nurseDataModel.setTriageType(triageType);
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name, gravity, visibleSymptom);
        nurseDataModel.addNewPatientToList(newPatient);
    }

}
