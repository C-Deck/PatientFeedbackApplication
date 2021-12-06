package com.clintdecker.patientfeedback.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.clintdecker.patientfeedback.model.Patient;
import com.clintdecker.patientfeedback.model.Diagnosis;
import com.clintdecker.patientfeedback.model.Doctor;
import com.clintdecker.patientfeedback.model.Appointment;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DataInitializerTest {
	// Constant values pulled from the json to confirm they were pulled properly
	private static final String PATIENT_ID = "6739ec3e-93bd-11eb-a8b3-0242ac130003";
	private static final String DOCTOR_ID = "9bf9e532-93bd-11eb-a8b3-0242ac130003";
	private static final String APPOINTMENT_ID = "be142dc6-93bd-11eb-a8b3-0242ac130003";
	
	private static DataInitializer dataInitializer = new DataInitializer();
	
	@BeforeAll
	public static void initData() {
		dataInitializer.InitData();
	}
	
	@Test
	public void patientCount() {
		assertEquals(1, dataInitializer.getPatients().size());
	}
	
	@Test
	public void patientInformation() {
		Patient patient = dataInitializer.getPatients().get(0);
		
		assertTrue(patient.isActive());
		assertEquals("Tendo", patient.getFirst());
		assertEquals("Tenderson", patient.getLast());
		assertEquals("female", patient.getGender());
	}
	
	@Test
	public void doctorCount() {
		assertEquals(1, dataInitializer.getDoctors().size());
	}
	
	@Test
	public void doctorInformation() {
		Doctor doctor = dataInitializer.getDoctors().get(0);
		
		assertEquals("Adam", doctor.getFirst());
		assertEquals("Careful", doctor.getLast());
	}
	
	@Test
	public void appointmentCount() {
		assertEquals(1, dataInitializer.getAppointments().size());
	}
	
	@Test
	public void appointmentInformation() {
		Appointment apt = dataInitializer.getAppointments().get(0);
		
		assertEquals("finished", apt.getStatus());
		assertEquals("Endocrinologist visit", apt.getType());
		assertEquals(PATIENT_ID, apt.getSubjectId());
		assertEquals(DOCTOR_ID, apt.getActorId());
	}
	
	@Test
	public void diagonisCount() {
		assertEquals(1, dataInitializer.getDiagnoses().size());
	}
	
	@Test
	public void diagonisInformation() {
		Diagnosis diagnosis = dataInitializer.getDiagnoses().get(0);
		
		assertEquals("final", diagnosis.getStatus());
		assertEquals("Diabetes without complications", diagnosis.getDescription());
		assertEquals(APPOINTMENT_ID, diagnosis.getAppointmentId());
	}
}
