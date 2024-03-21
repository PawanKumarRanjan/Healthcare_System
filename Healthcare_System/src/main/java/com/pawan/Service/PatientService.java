package com.pawan.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawan.Entity.Patient;
import com.pawan.Repository.PatientRep;

@Service
public class PatientService {

	@Autowired
    private PatientRep patientRepository;

    public Patient getPatientById(long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.orElse(null);
    }

}
