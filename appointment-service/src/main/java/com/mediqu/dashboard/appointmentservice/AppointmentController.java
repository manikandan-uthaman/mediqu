package com.mediqu.dashboard.appointmentservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mediqu.dashboard.appointmentservice.dto.AppointmentDto;
import com.mediqu.dashboard.appointmentservice.dto.DoctorDto;
import com.mediqu.dashboard.appointmentservice.dto.PatientDto;
import com.mediqu.dashboard.appointmentservice.entity.Appointment;

@RestController
@RequestMapping(path = "/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public List<AppointmentDto> getRecentAppointments(@RequestParam(name = "doctor", required = false) Integer doctorId, @RequestParam(name = "patient", required = false) Integer patientId) {

		List<Appointment> appointments = new ArrayList<Appointment>();
		List<AppointmentDto> result = new ArrayList<AppointmentDto>();

		if(doctorId != null) {
			appointments = appointmentRepository.findByDoctorId(doctorId);	
		} else if(patientId != null) {
			appointments = appointmentRepository.findByPatientId(patientId);	
		} else {
			appointments = appointmentRepository.findTop10ByOrderByStartTimeDesc();
		}
		
		if(CollectionUtils.isEmpty(appointments)) {
			return result;
		}
		
		StringBuilder sbr = new StringBuilder();
		sbr.append("http://doctor-service/doctors?id=");
		sbr.append(
				appointments.stream().map(app -> String.valueOf(app.getDoctorId())).collect(Collectors.joining(","))
		);
		
		ResponseEntity<DoctorDto[]> doctors = restTemplate.getForEntity(sbr.toString(), DoctorDto[].class);

		StringBuilder sb = new StringBuilder();
		sb.append("http://patient-service/patients?id=");
		sb.append(
				appointments.stream().map(app -> String.valueOf(app.getPatientId())).collect(Collectors.joining(","))
		);
		
		ResponseEntity<PatientDto[]> patients = restTemplate.getForEntity(sb.toString(), PatientDto[].class);
		
		
		appointments.forEach(app -> {
			AppointmentDto appointment = new AppointmentDto();
			appointment.setId(app.getId());
			appointment.setStartTime(app.getStartTime());
			appointment.setEndTime(app.getEndTime());
			appointment.setDoctor(getDoctor(doctors.getBody(), app.getDoctorId()));
			appointment.setPatient(getPatient(patients.getBody(), app.getPatientId()));
			result.add(appointment);
		});

		return result;
	}
	
	private DoctorDto getDoctor(DoctorDto[] doctors, Integer id) {
		return Arrays.asList(doctors).stream().filter(doc -> doc.getId() == id).findFirst().orElse(new DoctorDto());
	}

	private PatientDto getPatient(PatientDto[] patients, Integer id) {
		return Arrays.asList(patients).stream().filter(p -> p.getId() == id).findFirst().orElse(new PatientDto());
	}
}
