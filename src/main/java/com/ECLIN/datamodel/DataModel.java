package com.ECLIN.datamodel;

import com.ECLIN.Patient;
import com.ECLIN.enums.TriageType;

public interface DataModel {

    TriageType getTriageType();

    void setTriageType(TriageType triageType);

    void addNewPatientToList(Patient patient);

    boolean listIsEmpty();

    int getListNumberOfPatient();

    Patient getFirstPatientOnList();
}
