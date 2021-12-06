package com.clintdecker.patientfeedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clintdecker.patientfeedback.model.PatientResponse;
import com.clintdecker.patientfeedback.repository.PatientResponseRepository;

@RestController
@RequestMapping("/response")
public class PatientResponseController {

	@Autowired
	PatientResponseRepository patientResponseRepository;
	
	@PostMapping("/save")
	public void submitPatientFeedback(@RequestBody PatientResponse response) {
		// Nothing complex necessary - just save it
		patientResponseRepository.save(response);
	}
	
	@GetMapping("/retrieve/{id}")
	public PatientResponse getPatientResponse(@PathVariable("id") String id) {
		return patientResponseRepository.getById(id);
	}
}
