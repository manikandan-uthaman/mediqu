package com.mediqu.dashboard.patientservice.dto;

import java.util.Date;

public class PatientDto {

	private int id;
	private String name;
	private Date enrolledOn;
	private Date recentVisit;
	private String notes;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String phone;
	private String email;
	private String profilePic;
	private DoctorDto lastAttendedBy;

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
	public Date getEnrolledOn() {
		return enrolledOn;
	}
	public void setEnrolledOn(Date enrolledOn) {
		this.enrolledOn = enrolledOn;
	}
	public Date getRecentVisit() {
		return recentVisit;
	}
	public void setRecentVisit(Date recentVisit) {
		this.recentVisit = recentVisit;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
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
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public DoctorDto getLastAttendedBy() {
		return lastAttendedBy;
	}
	public void setLastAttendedBy(DoctorDto lastAttendedBy) {
		this.lastAttendedBy = lastAttendedBy;
	}
}
