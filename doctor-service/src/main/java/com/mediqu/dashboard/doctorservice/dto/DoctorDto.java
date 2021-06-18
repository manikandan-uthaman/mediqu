package com.mediqu.dashboard.doctorservice.dto;

import java.util.Date;

public class DoctorDto {
	private int id;
	private String name;
	private Date dateOfJoining;
	private Integer noOfReviews;
	private Double rating;
	private String speciality;
	private String description;
	private String profilePic;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String pincode;
	private String phone;
	private String email;
	private Patient assignedPatient;
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
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
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
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Patient getAssignedPatient() {
		return assignedPatient;
	}
	public void setAssignedPatient(Patient assignedPatient) {
		this.assignedPatient = assignedPatient;
	}

	
}
