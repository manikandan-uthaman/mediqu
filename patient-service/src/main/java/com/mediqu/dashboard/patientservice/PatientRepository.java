package com.mediqu.dashboard.patientservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediqu.dashboard.patientservice.entity.Patient;
import com.mediqu.dashboard.patientservice.entity.PatientView;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	List<PatientView> findBy();
	List<PatientView> findByIdIn(List<Integer> id);
	<T> Optional<T> findById(Integer id, Class<T> type);
}