package com.pawan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.Entity.Patient;

public interface PatientRep extends JpaRepository<Patient, Long> {
}