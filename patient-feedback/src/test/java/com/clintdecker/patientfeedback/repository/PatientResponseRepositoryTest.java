package com.clintdecker.patientfeedback.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.clintdecker.patientfeedback.model.PatientResponse;

@DataJpaTest
public class PatientResponseRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	PatientResponseRepository repository;
	
	@Test
	public void shouldFineNoneWhenEmpty() {
		Iterable<PatientResponse> responses = repository.findAll();
		
		assertThat(responses).isEmpty();
	}
	
	@Test
	public void shouldFindAll() {
		PatientResponse response1 = generateResponse("id-1");
		entityManager.persist(response1);
		PatientResponse response2 = generateResponse("id-2");
		entityManager.persist(response2);
		PatientResponse response3 = generateResponse("id-3");
		entityManager.persist(response3);
		
		
		Iterable<PatientResponse> responses = repository.findAll();
		assertThat(responses).hasSize(3).contains(response1, response2, response3);
	}
	
	private PatientResponse generateResponse(String appointmentId) {
		PatientResponse response = new PatientResponse();
		response.setAppointmentId(appointmentId);
		response.setDiagnosisThoughts("Appointment: " + appointmentId);
		response.setUnderstandsDiagnosis(true);
		response.setDoctorRecommendation(2);
		
		return response;
	}
}
