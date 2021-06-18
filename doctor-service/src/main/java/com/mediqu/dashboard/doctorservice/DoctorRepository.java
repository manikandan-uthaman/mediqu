package com.mediqu.dashboard.doctorservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediqu.dashboard.doctorservice.entity.Doctor;
import com.mediqu.dashboard.doctorservice.entity.DoctorView;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	List<DoctorView> findBy();
	List<DoctorView> findByIdIn(List<Integer> id);
	<T> Optional<T> findById(Integer id, Class<T> type);
}