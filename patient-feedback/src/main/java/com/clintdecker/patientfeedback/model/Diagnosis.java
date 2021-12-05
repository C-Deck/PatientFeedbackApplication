package com.clintdecker.patientfeedback.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "status")
    private String status;
	
	@Column(name = "appointmentId")
	private long appointmentId;
	
	@Column(name = "name")
	private String name;
	
	public Diagnosis() {
		//TODO
	}
}
