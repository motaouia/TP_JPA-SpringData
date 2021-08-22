package com.medmota.tpjpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.medmota.tpjpa.entities.Patient;
import com.medmota.tpjpa.repositories.PatientRepository;

@RestController
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@GetMapping("/allPatients")
	public List<Patient> getAllPatients(){
		return patientRepository.findAll();
	}
	
	@GetMapping("/patient/{id}")
	public Patient getPatientById(@PathVariable Long id) {
		return patientRepository.findById(id).get();
	}
	
	

}
