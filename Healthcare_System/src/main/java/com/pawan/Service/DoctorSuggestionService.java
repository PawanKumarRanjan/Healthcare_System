package com.pawan.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.Entity.Doctor;
import com.pawan.Repository.DoctorRep;

@Service
public class DoctorSuggestionService {

    @Autowired
    private DoctorRep doctorRepository;

    public List<Doctor> suggestDoctors(String location, String symptom) {
        String speciality = getSpeciality(symptom);

        if (speciality == null) {
            return Collections.emptyList();
        }

        return doctorRepository.findByCityAndSpeciality(location, speciality);
    }

    private String getSpeciality(String symptom) {
    	if (Arrays.asList("arthritis", "back pain", "tissue injuries").contains(symptom)) {
            return "orthopedic";
        } else if ("dysmenorrhea".equalsIgnoreCase(symptom)) {
            return "gynecology";
        } else if (Arrays.asList("skin infection", "skin burn").contains(symptom)) {
            return "dermatology";
        } else if ("ear pain".equalsIgnoreCase(symptom)) {
            return "ent";
        } else {
            return null;
        }
    }
}
