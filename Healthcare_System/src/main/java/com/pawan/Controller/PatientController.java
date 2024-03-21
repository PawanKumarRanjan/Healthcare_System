package com.pawan.Controller;
import java.util.Set;

import org.springframework.web.bind.annotation.*;

import com.pawan.Entity.*;
import com.pawan.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
    private PatientRep patientRepository;
	
	@PostMapping("/add-patient")
    public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
		
		String name=patient.getName();
    	if (name.length()<3) {
            return ResponseEntity.badRequest().body("Invalid Name : Name should be at least 3 characters");
        }

    	String phoneNumber=patient.getPhone_number();
    	if(phoneNumber.length()<10)
    	{
    		return ResponseEntity.badRequest().body("Invalid Phone Number");
    	}
    	
        if (!isValidSymptom(patient.getSymptom())) {
            return ResponseEntity.badRequest().body("Invalid Symptom");
        }
        
        patientRepository.save(patient);
        return ResponseEntity.ok("Patient Added Successfully");
    }
	
	private boolean isValidSymptom(String symptom) {
		 Set<String> validSymptoms = Set.of(
		            "arthritis",
		            "back pain",
		            "tissue injuries",
		            "dysmenorrhea",
		            "skin infection",
		            "skin burn",
		            "ear pain"
		    );

		    return validSymptoms.contains(symptom);
	}

	
	@DeleteMapping("/remove-patient/{patientId}")
    public ResponseEntity<String> removePatient(@PathVariable Long patientId) {
		
        if (!patientRepository.existsById(patientId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Patient Not Found");
        }

        patientRepository.deleteById(patientId);

        return ResponseEntity.ok("Patient Removed Successfully");
	}
	
}
