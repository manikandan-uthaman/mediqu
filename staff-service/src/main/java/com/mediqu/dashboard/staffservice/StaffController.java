package com.mediqu.dashboard.staffservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffController {
	
	@Autowired
	private StaffRepository staffRepository;
	
	@GetMapping("/count")
	private Long getStaffCount(@RequestParam(name = "type", required = false) Integer type) {
		if(type == null)
			return staffRepository.count();
		return staffRepository.countByType(type);
	}

}
