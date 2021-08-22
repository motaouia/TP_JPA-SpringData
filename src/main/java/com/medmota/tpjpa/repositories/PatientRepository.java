package com.medmota.tpjpa.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medmota.tpjpa.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	public List<Patient> findByNomContains(String motcle); 
	public List<Patient> findByMalade(boolean malade);
	public List<Patient> findByNomContainsAndMalade(String motCle, boolean malade);
	public Page<Patient> findByNomContains(String motcle, Pageable pageable);

}
