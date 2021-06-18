package com.mediqu.dashboard.patientservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediqu.dashboard.patientservice.entity.PatientHistory;

public interface PatientHistoryRepository extends JpaRepository<PatientHistory, Integer>{

	List<PatientHistory> findAllByPatientIdOrderByVisitedOnDesc(Integer id);
}
