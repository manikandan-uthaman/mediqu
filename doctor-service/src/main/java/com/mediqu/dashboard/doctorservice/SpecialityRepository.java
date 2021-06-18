package com.mediqu.dashboard.doctorservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediqu.dashboard.doctorservice.entity.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {
}