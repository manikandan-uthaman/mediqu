package com.mediqu.dashboard.reviewservice.dto;


public class ReviewDto {

	private Integer id;
	private String comments;
	private Double rating;
	private DoctorDto doctor;
	private PatientDto patient;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public DoctorDto getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorDto doctor) {
		this.doctor = doctor;
	}
	public PatientDto getPatient() {
		return patient;
	}
	public void setPatient(PatientDto patient) {
		this.patient = patient;
	}
	
	

}
