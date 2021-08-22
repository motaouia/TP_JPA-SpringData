package com.medmota.tpjpa;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.medmota.tpjpa.entities.Patient;
import com.medmota.tpjpa.repositories.PatientRepository;

@SpringBootApplication
public class TpJpaSpringdataApplication implements CommandLineRunner{

	@Autowired
	private PatientRepository patientRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TpJpaSpringdataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*patientRepository.save(new Patient(null, "ALI", new Date(), 4500, false));
		patientRepository.save(new Patient(null, "Mohamed", new Date(), 5900, false));
		patientRepository.save(new Patient(null, "Adam", new Date(), 2200, true));
		patientRepository.save(new Patient(null, "Samir", new Date(), 6600, false));
		patientRepository.save(new Patient(null, "Khadija", new Date(), 3890, true));
		patientRepository.save(new Patient(null, "Mustapha", new Date(), 7400, false));*/
		
		patientRepository.findAll().forEach(p -> {
			System.out.println("le Nom de Patient est : " + p.getNom());
		});
		
		System.out.println("@@==###########==@@");
		
		Patient patient = patientRepository.findById(1L).get();
		System.out.println("le Nom du Patient dont le Id est 1L : " + patient.getNom());
		
		System.out.println("@@==###########==@@");
		
		/*List<Patient> listPatients = patientRepository.findByNomContains("m");
		if(listPatients != null && listPatients.size() > 0) {
			//System.out.println();
			listPatients.forEach(pp -> {
				System.out.println(" ==> le nom de Patient est :  " + pp.getNom());
			});
		}*/
		//Using alternative Methode
		System.out.println("===> Using alternative Methode <===");
		Page<Patient> listPatients = patientRepository.findByNomContains("m", PageRequest.of(0, 2));
		if(listPatients != null && listPatients.getContent().size() > 0) {
			//System.out.println();
			listPatients.getContent().forEach(pp -> {
				System.out.println(" ==> le nom de Patient est :  " + pp.getNom());
			});
		}
		
			System.out.println("@@==###########==@@");
			
		List<Patient> lisPatientMalade = patientRepository.findByMalade(true);	
		if(lisPatientMalade != null && lisPatientMalade.size() > 0) {
			//System.out.println();
			lisPatientMalade.forEach(pp -> {
				System.out.println(" ==> le nom de Patient est :  " + pp.getNom());
			});
		}
		
		System.out.println("@@==###########==@@");
		
		
		List<Patient> listPatientMCAndMalde = patientRepository.findByNomContainsAndMalade("m", true);
		if(listPatientMCAndMalde != null && listPatientMCAndMalde.size() > 0) {
			//System.out.println();
			listPatientMCAndMalde.forEach(pp -> {
				System.out.println(" ==> le nom de Patient est :  " + pp.getNom());
			});
		}
		
		System.out.println("@@==###########==@@");
		
		//patientRepository.deleteById(3L);
		
		patientRepository.findAll().forEach(p -> {
			System.out.println("le Nom de Patient est : " + p.getNom());
		});
		
		System.out.println("@@==###########==@@");
		System.out.println("@@==####--Pagination--###==@@");
		System.out.println("@@==###########==@@");
		
		Page<Patient> patientsPage = patientRepository.findAll(PageRequest.of(1, 2));
		System.out.println("Nombre de pages est :" + patientsPage.getTotalPages());
		System.out.println("Nombre des elements est : " + patientsPage.getNumberOfElements());
		patientsPage.getContent().forEach(p -> {
			System.out.println("@@==> " + p.getNom());
		});
	}

}
