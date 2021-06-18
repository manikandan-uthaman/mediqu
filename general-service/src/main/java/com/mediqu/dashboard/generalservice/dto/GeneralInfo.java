package com.mediqu.dashboard.generalservice.dto;

public class GeneralInfo {
	
	private Long doctors;
	private Long patients;
	private Long nurses;
	private Long others;
	public Long getDoctors() {
		return doctors;
	}
	public void setDoctors(Long doctors) {
		this.doctors = doctors;
	}
	public Long getPatients() {
		return patients;
	}
	public void setPatients(Long patients) {
		this.patients = patients;
	}
	public Long getNurses() {
		return nurses;
	}
	public void setNurses(Long nurses) {
		this.nurses = nurses;
	}
	public Long getOthers() {
		return others;
	}
	public void setOthers(Long others) {
		this.others = others;
	}

}
