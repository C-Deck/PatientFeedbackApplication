package com.clintdecker.patientfeedback.data;

import java.util.ArrayList;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import com.clintdecker.patientfeedback.model.Patient;
import com.clintdecker.patientfeedback.model.Diagnosis;
import com.clintdecker.patientfeedback.model.Doctor;
import com.clintdecker.patientfeedback.model.Appointment;

// Makeshift DB for this project - load in the data needed
public class DataInitializer {
	// JSON file location to load
	private static String jsonFile = "C:\\Users\\Clint Desktop\\Documents\\TendoInterviewApp\\patient-feedback\\src\\main\\resources\\patient-feedback-raw-data.json";
	
	private List<Patient> patients;
	private List<Doctor> doctors;
	private List<Appointment> appointments;
	private List<Diagnosis> diagnoses;
	
	public DataInitializer() {
		patients = new ArrayList<>();
		doctors = new ArrayList<>();
		appointments = new ArrayList<>();
		diagnoses = new ArrayList<>();
	}
	
	// Retrieval methods
	public List<Patient> getPatients() {
		return patients;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public List<Diagnosis> getDiagnoses() {
		return diagnoses;
	}
	
	// Main function to load all the data from the JSON file into the lists
	public void InitData() {
		JSONObject obj = new JSONObject(readFileAsString(jsonFile));
		parseResource(obj);
	}
	
	private String readFileAsString(String file) {
		try {
			return new String(Files.readAllBytes(Paths.get(file)));
		} catch (Exception ex) {
			// Log file cannot open
		}
		
		return "";
    }

	private void parseResource(JSONObject resource) {
		try {
			String resourceType = resource.getString("resourceType");
			switch (resourceType) {
		   		case "Patient":
		   			parsePatient(resource);
		   			break;
		   		case "Doctor":
		   			parseDoctor(resource);
		   			break;
		   		case "Appointment":
		   			parseAppointment(resource);
		   			break;
		   		case "Diagnosis":
		   			parseDiagnosis(resource);
		   			break;
		   		case "Bundle":
		   			parseBundle(resource);
		   			break;
		   		default:
		   			// Do nothing
		   			break;
			}
		} catch (JSONException ex) {
			// Log this
		}
	}
	
	private void parseBundle(JSONObject resource) throws JSONException {
		// Get the bundle entry
	    JSONArray bundle = resource.getJSONArray("entry");

	    // Parse everything in the bundle
		for (int i = 0;i < bundle.length(); i++) {
			JSONObject entry = bundle.getJSONObject(i);
			// If the entry is a resource, parse it
			if (entry.has("resource")) {
				parseResource(entry.getJSONObject("resource"));
			}
		}
	}
	
	private void parsePatient(JSONObject resource) throws JSONException {
		Patient patient = new Patient();
		patient.setId(resource.getString("id"));
		patient.setActive(resource.getBoolean("active"));
		patient.setBirthDate(resource.getString("birthDate"));
		patient.setGender(resource.getString("gender"));
		
		JSONArray nameArray = resource.getJSONArray("name");
		patient.setFirst(getFirstName(nameArray));
		patient.setLast(getLastName(nameArray));
		
		patients.add(patient);
	}
	
	private void parseDoctor(JSONObject resource) throws JSONException {
		Doctor doctor = new Doctor();
		doctor.setId(resource.getString("id"));
		
		JSONArray nameArray = resource.getJSONArray("name");
		doctor.setFirst(getFirstName(nameArray));
		doctor.setLast(getLastName(nameArray));
		
		doctors.add(doctor);
	}
	
	// Helpers for Patient and Doctor who both have "name"
	private String getFirstName(JSONArray nameArray) {
		try {
			JSONObject obj = nameArray.getJSONObject(0);
			JSONArray givenArray = obj.getJSONArray("given");
			return givenArray.getString(0);
		} catch (JSONException ex) {
			// Log this
		}
		return "";
	}
	
	private String getLastName(JSONArray nameArray) {
		try {
			JSONObject obj = nameArray.getJSONObject(0);
			return obj.getString("family");
		} catch (JSONException ex) {
			// Log this
		}
		return "";
	}

	private void parseAppointment(JSONObject resource) throws JSONException {
		Appointment apt = new Appointment();
		apt.setId(resource.getString("id"));
		apt.setStatus(resource.getString("status"));
		
		String subjectId = extractReferenceId(resource.getJSONObject("subject"));
		apt.setSubjectId(subjectId);
		
		String actorId = extractReferenceId(resource.getJSONObject("actor"));
		apt.setActorId(actorId);
		
		apt.setType(resource.getJSONArray("type").getJSONObject(0).getString("text"));
		
		JSONObject period = resource.getJSONObject("period");
		apt.setStartDate(period.getString("start"));
		apt.setEndDate(period.getString("end"));;
		
		appointments.add(apt);
	}

	private void parseDiagnosis(JSONObject resource) throws JSONException {
		Diagnosis diagnosis = new Diagnosis();
		diagnosis.setId(resource.getString("id"));
		diagnosis.setStatus(resource.getString("status"));
		
		String aptId = extractReferenceId(resource.getJSONObject("appointment"));
		diagnosis.setAppointmentId(aptId);
		
		String descr = extractDiagnosisCodeName(resource.getJSONObject("code"));
		diagnosis.setDescription(descr);
		
		diagnoses.add(diagnosis);
	}
	
	private String extractDiagnosisCodeName(JSONObject code) {
		try {
			JSONObject coding = code.getJSONArray("coding").getJSONObject(0);
			return coding.getString("name");
		} catch (JSONException ex) {
			// Log this
		}

		return "";
	}
	
	// Helper to get reference Id and remove the resourceType
	private String extractReferenceId(JSONObject reference) {
		try {
		    String ref = reference.getString("reference");
		    return ref.substring(ref.indexOf("/") + 1);
		} catch (JSONException ex) {
			// Log this
		}

		return "";
	}
}
