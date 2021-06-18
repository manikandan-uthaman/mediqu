package com.mediqu.dashboard.reviewservice;

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

import com.mediqu.dashboard.reviewservice.dto.DoctorDto;
import com.mediqu.dashboard.reviewservice.dto.PatientDto;
import com.mediqu.dashboard.reviewservice.dto.ReviewDto;
import com.mediqu.dashboard.reviewservice.entity.Review;

@RestController
@RequestMapping(path = "/reviews")
public class ReviewController {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public List<ReviewDto> getReviews(@RequestParam(name = "doctor", required = false) Integer doctorId, @RequestParam(name = "patient", required = false) Integer patientId) {

		List<Review> reviews = new ArrayList<Review>();
		List<ReviewDto> result = new ArrayList<ReviewDto>();

		if(doctorId != null) {
			reviews = reviewRepository.findByDoctorId(doctorId);	
		} else if(patientId != null) {
			reviews = reviewRepository.findByPatientId(patientId);	
		}
		
		if(CollectionUtils.isEmpty(reviews)) {
			return result;
		}
		
		StringBuilder sbr = new StringBuilder();
		sbr.append("http://doctor-service/doctors?id=");
		sbr.append(
				reviews.stream().map(review -> String.valueOf(review.getDoctorId())).collect(Collectors.joining(","))
		);
		
		ResponseEntity<DoctorDto[]> doctors = restTemplate.getForEntity(sbr.toString(), DoctorDto[].class);

		StringBuilder sb = new StringBuilder();
		sb.append("http://patient-service/patients?id=");
		sb.append(
				reviews.stream().map(review -> String.valueOf(review.getPatientId())).collect(Collectors.joining(","))
		);
		
		ResponseEntity<PatientDto[]> patients = restTemplate.getForEntity(sb.toString(), PatientDto[].class);
		
		
		reviews.forEach(rev -> {
			ReviewDto review = new ReviewDto();
			review.setId(rev.getId());
			review.setComments(rev.getComments());
			review.setRating(rev.getRating());
			review.setDoctor(getDoctor(doctors.getBody(), rev.getDoctorId()));
			review.setPatient(getPatient(patients.getBody(), rev.getPatientId()));
			result.add(review);
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
