package com.clintdecker.patientfeedback.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;

//@Entity
//@Table(name = "diagnosis")
public class Diagnosis  extends BaseObject {
	
	//@Column(name = "status")
    private String status;
	
	//@Column(name = "appointmentId")
	private String appointmentId;
	
	//@Column(name = "description")
	private String description;
	
	public Diagnosis() {
		// Empty Constructor - Use get/set methods// Empty Constructor - Use get/set methods
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
