package com.clintdecker.patientfeedback.api.model;

import com.clintdecker.patientfeedback.model.Patient;
import com.clintdecker.patientfeedback.model.Diagnosis;
import com.clintdecker.patientfeedback.model.Doctor;

public class PatientFeedbackInformation {
	private Patient patient;
	
	private Doctor doctor;
	
	private Diagnosis diagnosis;
	
	// Empty Constructor where get/set can get used
	public PatientFeedbackInformation() {
	
	}
	
	// Constructor with everything
	public PatientFeedbackInformation(Patient patient, Doctor doctor, Diagnosis diagnosis) {
		this.setPatient(patient);
		this.setDoctor(doctor);
		this.setDiagnosis(diagnosis);
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}
}
