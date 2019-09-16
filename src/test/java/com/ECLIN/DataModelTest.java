package com.ECLIN;

import static org.junit.Assert.*;

import com.ECLIN.datamodel.DataModel;
import com.ECLIN.enums.TriageType;
import org.junit.Test;

public class DataModelTest {

    @Test
    public void afterInitDataModelTriageTypeMustBeSet() {
        DataModel dataModel = new DataModel(TriageType.FIFO);
        assertNotNull(dataModel.getTriageType());
    }
}
