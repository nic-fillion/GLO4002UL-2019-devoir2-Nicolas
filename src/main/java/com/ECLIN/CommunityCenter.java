package com.ECLIN;

import com.ECLIN.enums.ListType;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;

public class CommunityCenter extends Clinic {

    public CommunityCenter() {}

    public CommunityCenter(TriageType triageType) {
        super(triageType);
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient newPatient = new Patient(name, gravity, visibleSymptom);
        dataModel.addNewPatientToList(newPatient, ListType.NURSE);
    }

}
