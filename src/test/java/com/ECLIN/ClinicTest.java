package com.ECLIN;

import static org.junit.Assert.*;

import com.ECLIN.enums.ListType;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;
import com.ECLIN.healthInstitution.Clinic;
import org.junit.Test;

public class ClinicTest {

    @Test
    public void onInitDoctorListMustBeEmpty() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        assertTrue(clinic.listIsEmpty(clinic.getDataModel(ListType.DOCTOR)));
    }

    @Test
    public void onInitRadiologyListMustBeEmpty() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        assertTrue(clinic.listIsEmpty(clinic.getDataModel(ListType.RADIOLOGY)));
    }

    @Test
    public void afterPatientIsAddedDoctorListMustNotBeEmpty() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertFalse(clinic.listIsEmpty(clinic.getDataModel(ListType.DOCTOR)));
    }

    @Test
    public void afterPatientWithBrokenBoneOrSprainIsAddedRadiologyListMustNotBeEmpty() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertFalse(clinic.listIsEmpty(clinic.getDataModel(ListType.RADIOLOGY)));
    }

    @Test
    public void onTriagePatientMustBeAddedToDoctorList() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        int numberOfPatientDoctor = clinic.getListNumberOfPatient(clinic.getDataModel(ListType.DOCTOR));
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertEquals(numberOfPatientDoctor + 1, clinic.getListNumberOfPatient(clinic.getDataModel(ListType.DOCTOR)));
    }

    @Test
    public void onTriagePatientWithoutBrokenBoneOrSprainAreNotAddedToRadiologyList() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        int numberOfPatientRadiology = clinic.getListNumberOfPatient(clinic.getDataModel(ListType.RADIOLOGY));
        clinic.triagePatient("testPatient", 5, VisibleSymptom.CHEST_PAIN);
        assertEquals(numberOfPatientRadiology, clinic.getListNumberOfPatient(clinic.getDataModel(ListType.RADIOLOGY)));
    }

    @Test
    public void onTriagePatientWithBrokenBoneOrSprainAreAddedToRadiologyList() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        int numberOfPatientRadiology = clinic.getListNumberOfPatient(clinic.getDataModel(ListType.RADIOLOGY));
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertEquals(numberOfPatientRadiology + 1, clinic.getListNumberOfPatient(clinic.getDataModel(ListType.RADIOLOGY)));
    }

    @Test
    public void onTriagePatientWithEmptyDoctorListIsFirst() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertEquals("testPatient", clinic.getFirstPatient(clinic.getDataModel(ListType.DOCTOR)).getPatientName());
    }

    @Test
    public void onTriageSecondPatientIsNotFirstOnDoctorListWhenFIFO() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient("testSecondPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertNotEquals("testSecondPatient", clinic.getFirstPatient(clinic.getDataModel(ListType.DOCTOR)).getPatientName());
    }

    @Test
    public void afterTriagePatientWithHighGravityIsFirstOnDoctorListWhenGRAVITY() {
        Clinic clinic = new Clinic(TriageType.GRAVITY);
        clinic.triagePatient("testPatient", 3, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient("testSecondPatient", 7, VisibleSymptom.BROKEN_BONE);
        assertEquals("testSecondPatient", clinic.getFirstPatient(clinic.getDataModel(ListType.DOCTOR)).getPatientName());
    }

    @Test
    public void afterTriagePatientWithHighGravityIsFirstOnRadiologyListWhenGRAVITY() {
        Clinic clinic = new Clinic(TriageType.GRAVITY);
        clinic.triagePatient("testPatient", 3, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient("testSecondPatient", 7, VisibleSymptom.BROKEN_BONE);
        assertEquals("testSecondPatient", clinic.getFirstPatient(clinic.getDataModel(ListType.RADIOLOGY)).getPatientName());
    }

    @Test
    public void onTriagePatientWithGravity1IsNotIncludedOnTheLists() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        clinic.triagePatient("testPatient", 1, VisibleSymptom.BROKEN_BONE);
        assertEquals(0, clinic.getListNumberOfPatient(clinic.getDataModel(ListType.DOCTOR)));
        assertEquals(0, clinic.getListNumberOfPatient(clinic.getDataModel(ListType.RADIOLOGY)));
    }


}
