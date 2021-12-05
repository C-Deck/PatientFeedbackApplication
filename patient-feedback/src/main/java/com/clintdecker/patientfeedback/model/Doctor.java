package com.clintdecker.patientfeedback.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "first")
	private String first;
	
	@Column(name = "last")
	private String last;
	
	public Doctor() {
		//TODO
	}
}
