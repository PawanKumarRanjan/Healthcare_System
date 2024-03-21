package com.pawan.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;



@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Size(min = 3, message = "Name should be at least 3 characters")
    private String name;

    @Column(name = "city")
    @Size(max = 20, message = "City name should be at most 20 characters")
    private String city;

    @Column(name = "email", unique = true)
    @Email(message = "Invalid email address")
    private String email;

    @Column(name = "phone_number")
    @Size(min = 10, message = "Phone number should be at least 10 numbers")
    private String phone_number;

    @Column(name = "speciality")
    private String speciality;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city.toLowerCase();
	}

	public void setCity(String city) {
		this.city = city.toLowerCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getSpeciality() {
		return speciality.toLowerCase();
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality.toLowerCase();
	}
	

	public Doctor(Long id, @Size(min = 3, message = "Name should be at least 3 characters") String name,
			@Size(max = 20, message = "City name should be at most 20 characters") String city,
			@Email(message = "Invalid email address") String email,
			@Size(min = 10, message = "Phone number should be at least 10 numbers") String phone_number,
			String speciality) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.phone_number = phone_number;
		this.speciality = speciality;
	}

	public Doctor()
	{
		
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", phone_number="
				+ phone_number + ", speciality=" + speciality + "]";
	}

}

