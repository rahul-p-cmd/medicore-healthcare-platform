package com.medicore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicore.entity.Patient;
import com.medicore.service.PatientService;

@RestController
public class PatientController {
	
	private final PatientService patientService;
	
	public PatientController(PatientService patientService)
	{
		this.patientService=patientService;
	}
	@PostMapping("/patients")
	public Patient savePatient(@RequestBody Patient patient)
	{
		return patientService.savePatient(patient);
		
	}
	@GetMapping("/patients")
	public List<Patient> getAllPatients()
	{
		return patientService.getAllPatients();
	}
	@GetMapping("/patients/{id}")
	public Patient getPatientById(@PathVariable("id") Long id)
	{
		return patientService.getPatientById(id);
	}
	
	@PutMapping("patients/{id}")
	public Patient updatePatient(@PathVariable("id") Long Id ,@RequestBody Patient patient)
	{
		return patientService.updatePatient(Id, patient);
	}
	@DeleteMapping("patients/{id}")
	public void deletePatient(@PathVariable("id") Long id)
	{
		patientService.deletePatient(id);
	}

}
