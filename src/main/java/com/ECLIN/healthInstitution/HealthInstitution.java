package com.ECLIN.healthInstitution;

import com.ECLIN.Patient;
import com.ECLIN.datamodel.DataModel;
import com.ECLIN.enums.TriageType;

public abstract class HealthInstitution {

    public boolean listIsEmpty(DataModel dataModel) {
        return dataModel.listIsEmpty();
    }

    public int getListNumberOfPatient(DataModel dataModel) {
        return dataModel.getListNumberOfPatient();
    }

    public Patient getFirstPatient(DataModel dataModel) {
        return dataModel.getFirstPatientOnList();
    }

    public TriageType getTriageType(DataModel dataModel) {
        return dataModel.getTriageType();
    }

}
