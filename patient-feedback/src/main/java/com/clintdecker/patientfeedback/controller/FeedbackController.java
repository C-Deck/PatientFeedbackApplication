package com.clintdecker.patientfeedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.clintdecker.patientfeedback.api.model.PatientFeedbackInformation;
import com.clintdecker.patientfeedback.service.FeedbackService;

@CrossOrigin
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping("/appointment/{id}")
	public PatientFeedbackInformation getPatientFeedbackInformation(@PathVariable("id") String id) {
		return feedbackService.getPatientFeedbackInformation(id);
	}
}
