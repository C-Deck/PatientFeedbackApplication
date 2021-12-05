package com.clintdecker.patientfeedback.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "response")
public class PatientResponse {
	@Id
	private long patientId;

	@Column(name = "rating")
	private Integer doctorRecommendation;
	
	@Column(name = "understandsDiagnosis")
	private boolean understandsDiagnosis;
	
	@Column(name = "thoughts")
	private String diagnosisThoughts;
	
	public PatientResponse () {
		
	}
}
