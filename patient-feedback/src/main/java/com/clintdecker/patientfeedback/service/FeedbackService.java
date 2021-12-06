package com.clintdecker.patientfeedback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clintdecker.patientfeedback.model.Diagnosis;
import com.clintdecker.patientfeedback.model.Appointment;
import com.clintdecker.patientfeedback.model.BaseObject;
import com.clintdecker.patientfeedback.api.model.PatientFeedbackInformation;
import com.clintdecker.patientfeedback.data.DataInitializer;

@Service("feedbackService")
public class FeedbackService {
	
	// Autowired Repositories to get this information in a normal system
	private DataInitializer dataInitializer = new DataInitializer();
	
	public FeedbackService() {
		dataInitializer.InitData();
	}
	
	public PatientFeedbackInformation getPatientFeedbackInformation(String appointmentId) {
		PatientFeedbackInformation info = new PatientFeedbackInformation();
		
		// I would use db findById instead
		Appointment appointment = getObjectById(dataInitializer.getAppointments(), appointmentId);
		
		// Use the appointment.subjectId and actorId to get patient and doctor
		info.setPatient(getObjectById(dataInitializer.getPatients(), appointment.getSubjectId()));
		info.setDoctor(getObjectById(dataInitializer.getDoctors(), appointment.getActorId()));
		
		// Get the diagnosis where the diagnosis.appointmentId matches
		info.setDiagnosis(getDiagnosisByAptId(appointmentId));
		
		return info;
	}

	// Simple get by Id
	private <T extends BaseObject> T getObjectById(List<T> list, String id) {
		Optional<T> result = list.stream().filter(obj -> obj.getId().equals(id)).findFirst();
		
		return result.get();
	}
	
	// This would usually be a Repo function
	private Diagnosis getDiagnosisByAptId(String appointmentId) {
		Optional<Diagnosis> diagnosis = dataInitializer.getDiagnoses().stream().filter(diag -> diag.getAppointmentId().equals(appointmentId)).findFirst();
		
		return diagnosis.get();
	}
}
