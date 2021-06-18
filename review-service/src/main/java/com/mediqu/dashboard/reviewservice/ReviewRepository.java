package com.mediqu.dashboard.reviewservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediqu.dashboard.reviewservice.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	List<Review> findByDoctorId(Integer doctorId);
	List<Review> findByPatientId(Integer patientId);
}
