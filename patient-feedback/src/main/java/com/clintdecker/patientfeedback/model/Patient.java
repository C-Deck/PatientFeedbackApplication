package com.clintdecker.patientfeedback.model;

//import javax.persistence.Entity;
//import javax.persistence.Table;
//import javax.persistence.Column;

//@Entity
//@Table(name = "patient")
public class Patient extends BaseObject {
	
	//@Column(name = "active")
	private boolean active;
	
	//@Column(name = "birthDate")
	private String birthDate;
	
	//@Column(name = "gender")
	private String gender;
	
	//@Column(name = "first")
	private String first;
	
	//@Column(name = "last")
	private String last;
	
	public Patient() {
		// Empty Constructor - Use get/set methods
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
}
