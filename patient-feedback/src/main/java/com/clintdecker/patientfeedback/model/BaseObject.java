package com.clintdecker.patientfeedback.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BaseObject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected String id;
	
	public BaseObject() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
