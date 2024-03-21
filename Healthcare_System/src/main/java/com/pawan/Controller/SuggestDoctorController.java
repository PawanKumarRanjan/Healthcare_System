package com.pawan.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pawan.Entity.Doctor;
import com.pawan.Entity.Patient;
import com.pawan.Service.DoctorSuggestionService;
import com.pawan.Service.PatientService;

@RestController
@RequestMapping("/api")
public class SuggestDoctorController {

    @Autowired
    private DoctorSuggestionService doctorSuggestionService;

    @Autowired
    private PatientService patientService;

    @GetMapping("/suggest-doctors")
    public ResponseEntity<?> suggestDoctors(@RequestParam Long patientId) {
        Patient patient = patientService.getPatientById(patientId);

        if (patient == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient Not Found");
        }

        String location = patient.getCity();
        String symptom = patient.getSymptom();

        if (!isValidLocation(location)) {
            return ResponseEntity.ok("We are still waiting to expand to your location");
        }

        List<Doctor> suggestedDoctors = doctorSuggestionService.suggestDoctors(location, symptom);

        if (suggestedDoctors.isEmpty()) {
            return ResponseEntity.ok("There isn't any doctor present at your location for your symptom");
        }

        return ResponseEntity.ok(suggestedDoctors);
    }

    private boolean isValidLocation(String location) {
		 Set<String> validLocation = Set.of(
		            "delhi",
		            "noida",
		            "faridabad"
		    );
		 
		    return validLocation.contains(location);
	}
}