package com.clintdecker.patientfeedback.model;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;

//@Entity
//@Table(name = "appointment")
public class Appointment extends BaseObject {
	
	//@Column(name = "status")
	private String status;
	
	//@Column(name = "subjectId")
	private String subjectId;
	
	//@Column(name = "actorId")
	private String actorId;
	
	//@Column(name = "type")
	private String type;
	
	//@Column(name = "startDate")
	private String startDate;
	
	//@Column(name = "endDate")
	private String endDate;
	
	public Appointment() {
		// Empty Constructor - Use get/set methods
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getActorId() {
		return actorId;
	}

	public void setActorId(String actorId) {
		this.actorId = actorId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
