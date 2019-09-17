package com.ECLIN.healthInstitution;

import com.ECLIN.datamodel.DataModel;
import com.ECLIN.enums.ListType;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;

public interface HealthInstitution {

    public TriageType getTriageType();

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom);

    public DataModel getDataModel(ListType listType);

}
