package com.clintdecker.patientfeedback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "birthDate")
	private String birthDate;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "first")
	private String first;
	
	@Column(name = "last")
	private String last;
	
	public Patient() {
		// TODO
	}
}
