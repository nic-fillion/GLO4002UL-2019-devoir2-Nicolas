package com.ECLIN;

import static org.junit.Assert.*;
import org.junit.Test;

public class ClinicTest {

    @Test
    public void onInitDoctorListMustBeEmpty() {
        Clinic clinic = new Clinic();
        assertTrue(clinic.doctorListIsEmpty());
    }

    @Test
    public void onInitRadiologyListMustBeEmpty() {
        Clinic clinic = new Clinic();
        assertTrue(clinic.radiologyListIsEmpty());
    }

    @Test
    public void afterPatientIsAddedDoctorListMustNotBeEmpty() {
        Clinic clinic = new Clinic();
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertFalse(clinic.doctorListIsEmpty());
    }

    @Test
    public void afterPatientWithBrokenBoneOrSprainIsAddedRadiologyListMustNotBeEmpty() {
        Clinic clinic = new Clinic();
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertFalse(clinic.radiologyListIsEmpty());
    }

    @Test
    public void onTriagePatientMustBeAddedToDoctorList() {
        Clinic clinic = new Clinic();
        int numberOfPatientDoctor = clinic.getDoctorListNumberOfPatient();
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertEquals(numberOfPatientDoctor + 1, clinic.getDoctorListNumberOfPatient());
    }

    @Test
    public void onTriagePatientWithoutBrokenBoneOrSprainAreNotAddedToRadiologyList() {
        Clinic clinic = new Clinic();
        int numberOfPatientRadiology = clinic.getRadiologyListNumberOfPatient();
        clinic.triagePatient("testPatient", 5, VisibleSymptom.CHEST_PAIN);
        assertEquals(numberOfPatientRadiology, clinic.getRadiologyListNumberOfPatient());
    }

    @Test
    public void onTriagePatientWithBrokenBoneOrSprainAreAddedToRadiologyList() {
        Clinic clinic = new Clinic();
        int numberOfPatientRadiology = clinic.getRadiologyListNumberOfPatient();
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertEquals(numberOfPatientRadiology + 1, clinic.getRadiologyListNumberOfPatient());
    }

    @Test
    public void onTriagePatientWithEmptyDoctorListIsFirst() {
        Clinic clinic = new Clinic();
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertEquals("testPatient", clinic.getFirstPatient(ListType.DOCTOR).getPatientName());
    }

    @Test
    public void onTriageSecondPatientIsNotFirstOnDoctorList() {
        Clinic clinic = new Clinic();
        clinic.triagePatient("testPatient", 5, VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient("testSecondPatient", 5, VisibleSymptom.BROKEN_BONE);
        assertNotEquals("testSecondPatient", clinic.getFirstPatient(ListType.DOCTOR).getPatientName());
    }
}
