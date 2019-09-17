package com.ECLIN.healthInstitution;

import com.ECLIN.Patient;
import com.ECLIN.datamodel.DataModel;
import com.ECLIN.enums.TriageType;

public abstract class HealthInstitution {

    protected TriageType institutionTriageType;

    private void setTriageType(TriageType triageType) { institutionTriageType = triageType; }

    public TriageType getTriageType() { return institutionTriageType; }

    public HealthInstitution(TriageType triageType) { setTriageType(triageType); }

    public boolean listIsEmpty(DataModel dataModel) {
        return dataModel.listIsEmpty();
    }

    public int getListNumberOfPatient(DataModel dataModel) {
        return dataModel.getListNumberOfPatient();
    }

    public Patient getFirstPatient(DataModel dataModel) {
        return dataModel.getFirstPatientOnList();
    }
}
