package com.mediqu.dashboard.generalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mediqu.dashboard.generalservice.dto.GeneralInfo;

@RestController
@RequestMapping("/general")
public class GeneralController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/info")
	public GeneralInfo getGeneralInfo() {
		GeneralInfo generalInfo = new GeneralInfo();
		ResponseEntity<Long> doctorResponse = restTemplate.getForEntity("http://api-gateway/doctors/count", Long.class);
		ResponseEntity<Long> patientResponse = restTemplate.getForEntity("http://api-gateway/patients/count", Long.class);
		ResponseEntity<Long> allStaffsResponse = restTemplate.getForEntity("http://api-gateway/doctors/count", Long.class);
		
		ResponseEntity<Long> nursesResponse = restTemplate.getForEntity("http://api-gateway/staffs/count?type=1", Long.class);

		generalInfo.setDoctors(doctorResponse.getBody());
		generalInfo.setPatients(patientResponse.getBody());
		generalInfo.setNurses(nursesResponse.getBody());
		generalInfo.setOthers(allStaffsResponse.getBody() - nursesResponse.getBody());
		return generalInfo;
	}

}
