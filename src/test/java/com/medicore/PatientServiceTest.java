package com.medicore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.medicore.entity.Patient;
import com.medicore.repository.PatientRepository;
import com.medicore.service.PatientService;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {
	
	@Mock
	private PatientRepository patientRepository;
	
	@InjectMocks
	private PatientService patientService;
	
	@Test
	  void SavePatientTest()
	  {
		Patient patient=new Patient();
		patient.setName("rahul");
		patient.setEmail("rahul@gmail.com");
		
		when(patientRepository.save(patient)).thenReturn(patient);
		Patient result=patientService.savePatient(patient);
		
		assertEquals("rahul",result.getName());
		assertEquals("rahul@gmail.com",result.getEmail());
		verify(patientRepository).save(patient);
	  }

	     @Test
	      void getAllPatientsTest() {
	    	 Patient patient1 =new Patient();
	    	 patient1.setName("Rahul");
	    	 patient1.setEmail("rahul@gmail.com");
	    	 Patient patient2 =new Patient();
	    	 patient2.setName("Amit");
	    	 patient2.setName("amit@gmail.com");
	    	 
	    	 List<Patient> patientList = Arrays.asList(patient1, patient2);
	    	 
	    	 when(patientRepository.findAll()).thenReturn(patientList);
	    	  List<Patient> result=patientService.getAllPatients();
	    	  assertEquals(2,result.size());
	    	  verify(patientRepository).findAll();
	     }
	    	  
	    	  @Test
	    	  void getPatientById()
	    	  {
	    		  Patient patient=new Patient();
	    		  patient.setId(1L);
	    		  patient.setName("Rahul");
	    		  when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));
	    		  
	    		  Patient result=patientService.getPatientById(1l);
	    		  
	    		  assertEquals("Rahul",result.getName());
	    		  verify(patientRepository).findById(1L);
	    
           }
	    	  @Test
	    	  void getPatientByIdNotFoundTest() {
	    		  when(patientRepository.findById(999L)).thenReturn(Optional.empty());
	    		  
	    		  //patientService.getPatientById(99L);
	    		  assertThrows(NoSuchElementException.class, () -> {
	    			    patientService.getPatientById(999L);
	    			});

	    	  }
	    	  
	    	  @Test
	    	  void updatePtientTest()
	    	  {
	    		  Patient existingPatient= new Patient();
	    		  existingPatient.setId(1L);
	    		  existingPatient.setName("Rahul");
	    		  Patient updatedPatient = new Patient();
	    		  updatedPatient.setName("Amit");
	    		  updatedPatient.setEmail("amit@gmail.com");
	    		  when(patientRepository.findById(1L)).thenReturn(Optional.of(existingPatient));
	    		  when(patientRepository.save(existingPatient)).thenReturn(existingPatient);
	    		  Patient result=patientService.updatePatient(1L, updatedPatient);
	    		  assertEquals("Amit",result.getName());
	    		  assertEquals("amit@gmail.com", result.getEmail());
	    		  verify(patientRepository).save(existingPatient);

	    	  }
	    	  @Test
	    	  void deletePatientTest()
	    	  {
	    		  patientService.deletePatient(1L);
	    		  
	    		  verify(patientRepository).deleteById(1L);
	    	  }
	    	  

}
