package com.pawan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawan.Entity.Doctor;

import java.util.List;

public interface DoctorRep extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(String city, String speciality);
    }