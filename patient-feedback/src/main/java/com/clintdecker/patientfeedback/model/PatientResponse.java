package com.clintdecker.patientfeedback.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "response")
public class PatientResponse {
	@Id
	private String appointmentId;

	@Column(name = "rating")
	private Integer doctorRecommendation;
	
	@Column(name = "understandsDiagnosis")
	private boolean understandsDiagnosis;
	
	@Column(name = "thoughts")
	private String diagnosisThoughts;
	
	public PatientResponse () {
		
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Integer getDoctorRecommendation() {
		return doctorRecommendation;
	}

	public void setDoctorRecommendation(Integer doctorRecommendation) {
		this.doctorRecommendation = doctorRecommendation;
	}

	public boolean isUnderstandsDiagnosis() {
		return understandsDiagnosis;
	}

	public void setUnderstandsDiagnosis(boolean understandsDiagnosis) {
		this.understandsDiagnosis = understandsDiagnosis;
	}

	public String getDiagnosisThoughts() {
		return diagnosisThoughts;
	}

	public void setDiagnosisThoughts(String diagnosisThoughts) {
		this.diagnosisThoughts = diagnosisThoughts;
	}
}
