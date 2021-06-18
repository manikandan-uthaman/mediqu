package com.mediqu.dashboard.appointmentservice.dto;

import java.util.Date;

public class PatientDto {
	private Integer id;
	private String name;
	private Date recentVisit;
	private String profilePic;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRecentVisit() {
		return recentVisit;
	}
	public void setRecentVisit(Date recentVisit) {
		this.recentVisit = recentVisit;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
	
}
