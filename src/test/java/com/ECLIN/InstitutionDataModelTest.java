package com.ECLIN;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClinicDataModelTest {

    @Test
    public void afterInitDataModelTriageTypeMustBeSet() {
        ClinicDataModel dataModel = new ClinicDataModel();
        assertNotNull(dataModel.getClinicTriageType());
    }
}
