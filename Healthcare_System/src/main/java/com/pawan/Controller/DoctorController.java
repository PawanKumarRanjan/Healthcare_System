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
public class DoctorController {
	
    @Autowired
    private DoctorRep doctorRepository;
    
    @PostMapping("/add-doctor")
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
    	
    	String name=doctor.getName();
    	if (name.length()<3) {
            return ResponseEntity.badRequest().body("Invalid Name : Name should be at least 3 characters");
        }
    	
    	if (!isValidCity(doctor.getCity())) {
            return ResponseEntity.badRequest().body("Invalid City");
        }
    	
    	String phoneNumber=doctor.getPhone_number();
    	if(phoneNumber.length()<10)
    	{
    		return ResponseEntity.badRequest().body("Invalid Phone Number");
    	}
    	
    	if (!isValidSpeciality(doctor.getSpeciality())) {
            return ResponseEntity.badRequest().body("Invalid Speciality");
        }
    	
        doctorRepository.save(doctor);
        return ResponseEntity.ok("Doctor Added Successfully");
    }
    
    private boolean isValidCity(String city) {
		 Set<String> validCity = Set.of(
		            "delhi",
		            "noida",
		            "faridabad"
		    );
		 
		    return validCity.contains(city);
	}
    
    private boolean isValidSpeciality(String speciality) {
    	Set<String> validSpeciality = Set.of(
	            "orthopedic",
	            "gynecology",
	            "dermatology",
	            "ent"
	    );
    	
	    return validSpeciality.contains(speciality);
	}

    
	@DeleteMapping("/remove-doctor/{doctorId}")
    public ResponseEntity<String> removeDoctor(@PathVariable Long doctorId) {

        if (!doctorRepository.existsById(doctorId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Doctor Not Found");
        }
        
        doctorRepository.deleteById(doctorId);

        return ResponseEntity.ok("Doctor Removed Successfully");
    }
	
}