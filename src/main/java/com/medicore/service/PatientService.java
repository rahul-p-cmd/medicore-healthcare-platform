package com.medicore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;


import com.medicore.entity.Patient;
import com.medicore.entity.PaymentStatus;
import com.medicore.repository.PatientRepository;

@Service
public class PatientService {
	
	private final PatientRepository patientRepository;
	
	public PatientService(PatientRepository patientRepository)
	{
		this.patientRepository=patientRepository;
		
	}
	// Git workflow practice
	// Git GUI workflow practice
	/*public Patient savePatient(Patient patient)
	{
		return patientRepository.save(patient);
	}*/
	
	
	public Patient savePatient(Patient patient)
	{
		//Insurance YES hai, lekin plan nahi diya
		
		if(Boolean.TRUE.equals(patient.getInsuranceRequired())&&patient.getInsurancePlan()==null)
			
			throw new IllegalArgumentException("insurance plan is required");
		// 2. Insurance NO hai, lekin plan diya hai invalid case
		
		if (Boolean.FALSE.equals(patient.getInsuranceRequired())
		        && patient.getInsurancePlan() != null) {

		    throw new IllegalArgumentException(
		            "Insurance plan should not be selected when insurance is not required");
		}
		// 3. Insurance YES hai
		
		if(Boolean.TRUE.equals(patient.getInsuranceRequired()))
		{
			patient.setPaymentStatus(PaymentStatus.PENDING);
		}
		// 4. Insurance NO hai.valid case
		if (Boolean.FALSE.equals(patient.getInsuranceRequired())) {
		    patient.setInsurancePlan(null);
		    patient.setPaymentStatus(null);
		}
		
		
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