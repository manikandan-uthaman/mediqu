package com.mediqu.dashboard.patientservice.entity;

import java.util.Date;

public interface PatientView {
	public int getId();
	public String getName();
	public Date getRecentVisit();
	public String getProfilePic();
}
