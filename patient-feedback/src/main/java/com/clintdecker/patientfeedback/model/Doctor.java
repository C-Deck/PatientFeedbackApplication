package com.clintdecker.patientfeedback.model;

//import javax.persistence.Column;

//@Entity
//@Table(name = "doctor")
public class Doctor extends BaseObject {
	//@Column(name = "first")
	private String first;
	
	//@Column(name = "last")
	private String last;
	
	public Doctor() {
		// Empty Constructor - Use get/set methods
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}
}
