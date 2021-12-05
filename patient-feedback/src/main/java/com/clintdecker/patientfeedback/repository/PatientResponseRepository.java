package com.clintdecker.patientfeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clintdecker.patientfeedback.model.PatientResponse;

public interface PatientResponseRepository extends JpaRepository<PatientResponse, Long> {
	//TODO
}
