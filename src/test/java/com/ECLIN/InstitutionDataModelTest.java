package com.ECLIN;

import static org.junit.Assert.*;

import org.junit.Test;

public class InstitutionDataModelTest {

    @Test
    public void afterInitDataModelTriageTypeMustBeSet() {
        InstitutionDataModel dataModel = new InstitutionDataModel();
        assertNotNull(dataModel.getClinicTriageType());
    }
}
