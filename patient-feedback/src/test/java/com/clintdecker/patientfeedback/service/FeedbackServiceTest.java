package com.clintdecker.patientfeedback.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.clintdecker.patientfeedback.model.Doctor;

// Mockito would be preferred for this in order to mock the dataInitializer results
public class FeedbackServiceTest {
	private FeedbackService feedbackService = new FeedbackService();
	
	@Test
	public void getObjectByIdTest() {
		List<Doctor> doctors = new ArrayList<>();
		Doctor doc1 = generateDoctor("id-1");
		doctors.add(doc1);
		
		Doctor doc2 = generateDoctor("id-2");
		doctors.add(doc2);
		
		Doctor doc3 = generateDoctor("id-3");
		doctors.add(doc3);

		Doctor result = feedbackService.getObjectById(doctors, "id-2");
		assertEquals(doc2, result);
	}
	
	private Doctor generateDoctor(String id) {
		Doctor d = new Doctor();
		d.setId(id);
		d.setFirst("first-" + id);
		d.setLast("last" + id);
		
		return d;
	}
}
