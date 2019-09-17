package com.ECLIN.healthInstitution;

import com.ECLIN.Patient;
import com.ECLIN.datamodel.DataModel;
import com.ECLIN.enums.ListType;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;

public class CommunityCenter implements HealthInstitution {

    private TriageType institutionTriageType;
    private DataModel nurseDataModel;

    public CommunityCenter(TriageType triageType) {
        institutionTriageType = triageType;
        nurseDataModel = new DataModel(triageType);
    }

    public TriageType getTriageType() { return institutionTriageType; }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name, gravity, visibleSymptom);
        nurseDataModel.addNewPatientToList(newPatient);
    }

    public DataModel getDataModel(ListType listType) {
        return nurseDataModel;
    }
}
