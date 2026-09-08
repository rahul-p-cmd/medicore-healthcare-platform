package com.medicore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;


import com.medicore.entity.Patient;
import com.medicore.repository.PatientRepository;

@Service
public class PatientService {
	
	private final PatientRepository patientRepository;
	
	public PatientService(PatientRepository patientRepository)
	{
		this.patientRepository=patientRepository;
		
	}
	public Patient savePatient(Patient patient)
	{
		return patientRepository.save(patient);
	}

	public List<Patient> getAllPatients()
	{
		return patientRepository.findAll();
		
		}

	/*public Patient getPatientById(Long id)
	{
		return patientRepository.findById(id).get();
		
	}*/

	public Patient getPatientById(Long id) {
	    return patientRepository.findById(id)
	            .orElseThrow(() ->
	                    new NoSuchElementException("Patient not found with id: " + id));
	}
	
	public Patient updatePatient(Long id,Patient patient)
	{
		Patient existingPatient=patientRepository.findById(id).orElseThrow(
				()->new NoSuchElementException("patient not found with id="+id));
		
		existingPatient.setName(patient.getName());
		existingPatient.setEmail(patient.getEmail());
		existingPatient.setPhone(patient.getPhone());
		existingPatient.setAge(patient.getAge());
		existingPatient.setGender(patient.getGender());
		existingPatient.setAddress(patient.getAddress());
		
		return patientRepository.save(existingPatient);
				
	}

public void deletePatient(Long id)
{
	patientRepository.deleteById(id);
}




} 