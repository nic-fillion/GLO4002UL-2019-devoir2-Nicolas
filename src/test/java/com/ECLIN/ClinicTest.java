package com.ECLIN;

import static org.junit.Assert.*;

import com.ECLIN.enums.ListType;
import com.ECLIN.enums.TriageType;
import com.ECLIN.enums.VisibleSymptom;
import com.ECLIN.healthInstitution.Clinic;
import org.junit.Test;

public class ClinicTest {

    @Test
    public void afterInit_thenInitDoctorListMustBeEmpty() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        assertTrue(clinic.getDataModel(ListType.DOCTOR).listIsEmpty());
    }

    @Test
    public void afterInit_thenRadiologyListMustBeEmpty() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        assertTrue(clinic.getDataModel(ListType.RADIOLOGY).listIsEmpty());
    }

    @Test
    public void afterPatientIsAdded_thenDoctorListMustNotBeEmpty() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertFalse(clinic.getDataModel(ListType.DOCTOR).listIsEmpty());
    }

    @Test
    public void afterPatientWithBrokenBoneOrSprainIsAdded_thenRadiologyListMustNotBeEmpty() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertFalse(clinic.getDataModel(ListType.RADIOLOGY).listIsEmpty());
    }

    @Test
    public void onTriage_thenPatientMustBeAddedToDoctorList() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        int numberOfPatientDoctor = clinic.getDataModel(ListType.DOCTOR).getListNumberOfPatient();
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertEquals(numberOfPatientDoctor + 1, clinic.getDataModel(ListType.DOCTOR).getListNumberOfPatient());
    }

    @Test
    public void onTriage_thenPatientWithoutBrokenBoneOrSprainAreNotAddedToRadiologyList() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        int numberOfPatientRadiology = clinic.getDataModel(ListType.RADIOLOGY).getListNumberOfPatient();
        clinic.triagePatient("testPatient", 5, VisibleSymptom.CHEST_PAIN);
        assertEquals(numberOfPatientRadiology, clinic.getDataModel(ListType.RADIOLOGY).getListNumberOfPatient());
    }

    @Test
    public void onTriage_thenPatientWithBrokenBoneOrSprainAreAddedToRadiologyList() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        int numberOfPatientRadiology = clinic.getDataModel(ListType.RADIOLOGY).getListNumberOfPatient();
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertEquals(numberOfPatientRadiology + 1, clinic.getDataModel(ListType.RADIOLOGY).getListNumberOfPatient());
    }

    @Test
    public void onTriage_thenPatientWithEmptyDoctorListIsFirst() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertEquals("testPatient", clinic.getDataModel(ListType.DOCTOR).getFirstPatientOnList().getPatientName());
    }

    @Test
    public void onTriage_thenSecondPatientIsNotFirstOnDoctorListWhenFIFO() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient("testSecondPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertNotEquals("testSecondPatient", clinic.getDataModel(ListType.DOCTOR).getFirstPatientOnList().getPatientName());
    }

    @Test
    public void onTriage_thenPatientWithHighGravityIsFirstOnDoctorListWhenGRAVITY() {
        Clinic clinic = new Clinic(TriageType.GRAVITY);
        clinic.triagePatient("testPatient", 3, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient("testSecondPatient", 7, VisibleSymptom.BROKEN_BONE);
        assertEquals("testSecondPatient", clinic.getDataModel(ListType.DOCTOR).getFirstPatientOnList().getPatientName());
    }

    @Test
    public void onTriage_thenPatientWithHighGravityIsFirstOnRadiologyListWhenGRAVITY() {
        Clinic clinic = new Clinic(TriageType.GRAVITY);
        clinic.triagePatient("testPatient", 3, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient("testSecondPatient", 7, VisibleSymptom.BROKEN_BONE);
        assertEquals("testSecondPatient", clinic.getDataModel(ListType.RADIOLOGY).getFirstPatientOnList().getPatientName());
    }

    @Test
    public void onTriage_thenPatientWithGravity1IsNotIncludedOnTheLists() {
        Clinic clinic = new Clinic(TriageType.FIFO);
        clinic.triagePatient("testPatient", 1, VisibleSymptom.BROKEN_BONE);
        assertEquals(0, clinic.getDataModel(ListType.DOCTOR).getListNumberOfPatient());
        assertEquals(0, clinic.getDataModel(ListType.RADIOLOGY).getListNumberOfPatient());
    }


}
