package com.mediqu.dashboard.patientservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mediqu.dashboard.patientservice.dto.DoctorDto;
import com.mediqu.dashboard.patientservice.dto.PatientDto;
import com.mediqu.dashboard.patientservice.entity.Patient;
import com.mediqu.dashboard.patientservice.entity.PatientHistory;
import com.mediqu.dashboard.patientservice.entity.PatientView;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientHistoryRepository patientHistoryRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${doctor.service.url}")
	private String doctorServiceUrl;

	@GetMapping("/count")
	public Long getPatientCount() {
		return patientRepository.count();
	}

	@GetMapping
	public List<PatientView> getAllPatients(@RequestParam(name = "id", required = false) List<Integer> id) {
		
		if(CollectionUtils.isEmpty(id))
			return patientRepository.findBy();

		return patientRepository.findByIdIn(id);
	}
	
	@GetMapping("/{id}")
	public PatientDto getPatient(@PathVariable("id") Integer patientId) {
		Patient patient = patientRepository.findById(patientId, Patient.class).orElse(new Patient());
		PatientDto result = this.convertEntityToDto(patient);
		ResponseEntity<DoctorDto> response = restTemplate.getForEntity(doctorServiceUrl + "/doctors/" + patient.getLastAttended() + "/basic-info", DoctorDto.class);
		result.setLastAttendedBy(response.getBody());
		return result;
	}

	@GetMapping("/{id}/basic-info")
	public PatientView getPatientBasicInfo(@PathVariable("id") Integer patientId) {
		return patientRepository.findById(patientId, PatientView.class).orElse(new PatientView() {
			public Date getRecentVisit() {
				return null;
			}
			public String getProfilePic() {
				return null;
			}
			public String getName() {
				return null;
			}
			public int getId() {
				return 0;
			}
		});
	}
	
	@GetMapping("/history/{id}")
	public List<PatientHistory> getPatientHistory(@PathVariable("id") Integer patientId) {
		return patientHistoryRepository.findAllByPatientIdOrderByVisitedOnDesc(patientId);
	}
	
	private PatientDto convertEntityToDto(Patient patient) {
		PatientDto result = new PatientDto();
		result.setId(patient.getId());
		result.setName(patient.getName());
		result.setEnrolledOn(patient.getEnrolledOn());
		result.setRecentVisit(patient.getRecentVisit());
		result.setNotes(patient.getNotes());
		result.setAddressLine1(patient.getAddressLine1());
		result.setAddressLine2(patient.getAddressLine2());
		result.setCity(patient.getCity());
		result.setPhone(patient.getPhone());
		result.setEmail(patient.getEmail());
		result.setProfilePic(patient.getProfilePic());
		return result;
	}
}
