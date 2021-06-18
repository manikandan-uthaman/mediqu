package com.mediqu.dashboard.doctorservice;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

import com.mediqu.dashboard.doctorservice.dto.DoctorDto;
import com.mediqu.dashboard.doctorservice.dto.Patient;
import com.mediqu.dashboard.doctorservice.entity.Doctor;
import com.mediqu.dashboard.doctorservice.entity.DoctorView;
import com.mediqu.dashboard.doctorservice.entity.Speciality;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private SpecialityRepository specialityRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${patient.service.url}")
	private String patientServiceUrl;
	
	private List<Speciality> specialities;
	
	@GetMapping("/count")
	public Long getDoctorsCount() {
		return doctorRepository.count();
	}
	
	@GetMapping
	public List<DoctorView> getAllDoctors(@RequestParam(name = "id", required = false) List<Integer> id) {
		
		if(CollectionUtils.isEmpty(id))
			return doctorRepository.findBy();

		return doctorRepository.findByIdIn(id);
	}
	
	@GetMapping("/{id}")
	public DoctorDto getDoctor(@PathVariable("id") Integer doctorId) {
		Doctor doctor = doctorRepository.findById(doctorId, Doctor.class).orElse(new Doctor());
		HashMap<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("id", doctor.getAssignedPatient().toString());
		ResponseEntity<Patient> response = restTemplate.getForEntity(patientServiceUrl + "/patients/{id}/basic-info", Patient.class, uriVariables);
		DoctorDto result = this.convertEntityToDto(doctor);
		result.setAssignedPatient(response.getBody());
		return result;
	}

	@GetMapping("/{id}/basic-info")
	public DoctorView getDoctorBasicInfo(@PathVariable("id") Integer doctorId) {
		return doctorRepository.findById(doctorId, DoctorView.class).orElse(new DoctorView() {
			public Integer getNoOfReviews() {
				return null;
			}
			public Double getRating() {
				return null;
			}
			public Integer getSpeciality() {
				return null;
			}
			public int getId() {
				return 0;
			}
			public String getName() {
				return null;
			}
			public String getProfilePic() {
				return null;
			}
		});
	}	
	
	
	private DoctorDto convertEntityToDto(Doctor doctor) {
		DoctorDto  result = new DoctorDto();
		result.setId(doctor.getId());
		result.setName(doctor.getName());
		result.setDateOfJoining(doctor.getDateOfJoining());
		result.setNoOfReviews(doctor.getNoOfReviews());
		result.setRating(doctor.getRating());
		result.setSpeciality(this.getSpeciality(doctor.getSpeciality()));
		result.setDescription(doctor.getDescription());
		result.setProfilePic(doctor.getProfilePic());
		result.setAddressLine1(doctor.getAddressLine1());
		result.setAddressLine2(doctor.getAddressLine2());
		result.setCity(doctor.getCity());
		result.setPincode(doctor.getPincode());
		result.setPhone(doctor.getPhone());
		result.setEmail(doctor.getEmail());

		return result;
	}
	
	private String getSpeciality(Integer id) {
		if(CollectionUtils.isEmpty(specialities)) {
			specialities = specialityRepository.findAll();
		}
		
		Optional<Speciality> sp = specialities.stream().filter(s -> s.getId() == id).findFirst();
		if(sp.isPresent()) {
			return sp.get().getName();
		} else {
			return null;
		}
	}
}
