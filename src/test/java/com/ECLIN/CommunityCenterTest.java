package com.ECLIN;

import static org.junit.Assert.*;

import com.ECLIN.enums.ListType;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;
import com.ECLIN.healthInstitution.CommunityCenter;
import org.junit.Test;

public class CommunityCenterTest {

    @Test
    public void onInitNurseListIsEmpty() {
        CommunityCenter communityCenter = new CommunityCenter(TriageType.FIFO);
        assertEquals(0, communityCenter.getListNumberOfPatient(communityCenter.getDataModel()));
    }

    @Test
    public void afterTriageNurseListIsNoLongerEmpty() {
        CommunityCenter communityCenter = new CommunityCenter();
        communityCenter.triagePatient("testSecondPatient", 3, VisibleSymptom.BROKEN_BONE);
        assertEquals(1, communityCenter.getListNumberOfPatient(ListType.NURSE));
    }

    @Test
    public void afterInitTriageTypeMustBeFIFOWhenNoParamConstructor() {
        CommunityCenter communityCenter = new CommunityCenter();
        assertEquals(TriageType.FIFO, communityCenter.getTriageType());
    }

    @Test
    public void afterInitTriageTypeMustBeGRAVITYWhenThisParamInConstructor() {
        CommunityCenter communityCenter = new CommunityCenter(TriageType.GRAVITY);
        assertEquals(TriageType.GRAVITY, communityCenter.getTriageType());
    }

    @Test
    public void onTriagePatientMustBeAddedToNurseList() {
        CommunityCenter communityCenter = new CommunityCenter();
        int numberOfPatientNurse = communityCenter.getListNumberOfPatient(ListType.NURSE);
        communityCenter.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertEquals(numberOfPatientNurse + 1, communityCenter.getListNumberOfPatient(ListType.NURSE));
    }

    @Test
    public void onTriagePatientWithHighGravityMustBeAddedFirstWhenGRAVITY() {
        CommunityCenter communityCenter = new CommunityCenter(TriageType.GRAVITY);
        communityCenter.triagePatient("testPatient", 3, VisibleSymptom.BROKEN_BONE);
        communityCenter.triagePatient("testSecondPatient", 7, VisibleSymptom.BROKEN_BONE);
        assertEquals("testSecondPatient", communityCenter.getFirstPatient(ListType.NURSE).getPatientName());
    }

    @Test
    public void onTriagePatientWithLowGravityMustBeAddedLastWhenGRAVITY() {
        CommunityCenter communityCenter = new CommunityCenter(TriageType.GRAVITY);
        communityCenter.triagePatient("testPatient", 3, VisibleSymptom.BROKEN_BONE);
        communityCenter.triagePatient("testSecondPatient", 3, VisibleSymptom.BROKEN_BONE);
        assertNotEquals("testSecondPatient", communityCenter.getFirstPatient(ListType.NURSE).getPatientName());
    }

    @Test
    public void onTriagePatientWithGravity1IsNotIncludedOnTheList() {
        CommunityCenter communityCenter = new CommunityCenter();
        communityCenter.triagePatient("testPatient", 1, VisibleSymptom.BROKEN_BONE);
        assertEquals(0, communityCenter.getListNumberOfPatient(ListType.NURSE));
    }
}
