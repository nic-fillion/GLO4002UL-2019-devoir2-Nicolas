package com.ECLIN.healthInstitution;

import com.ECLIN.Patient;
import com.ECLIN.datamodel.DataModel;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;

public class CommunityCenter extends HealthInstitution {

    private DataModel nurseDataModel = new DataModel(institutionTriageType);

    public CommunityCenter(TriageType triageType) {
        super(triageType);
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name, gravity, visibleSymptom);
        nurseDataModel.addNewPatientToList(newPatient);
    }

    public DataModel getDataModel() {
        return nurseDataModel;
    }
}
