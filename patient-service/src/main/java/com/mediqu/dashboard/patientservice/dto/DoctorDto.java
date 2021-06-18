package com.mediqu.dashboard.patientservice.dto;

public class DoctorDto {

	private int id;
	private String name;
	private Integer noOfReviews;
	private Double rating;
	private Integer speciality;
	private String profilePic;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNoOfReviews() {
		return noOfReviews;
	}
	public void setNoOfReviews(Integer noOfReviews) {
		this.noOfReviews = noOfReviews;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Integer getSpeciality() {
		return speciality;
	}
	public void setSpeciality(Integer speciality) {
		this.speciality = speciality;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
}
