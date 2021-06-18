package com.mediqu.dashboard.appointmentservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediqu.dashboard.appointmentservice.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
	
	List<Appointment> findTop10ByOrderByStartTimeDesc();
	List<Appointment> findByDoctorId(Integer doctorId);
	List<Appointment> findByPatientId(Integer patientId);
}
