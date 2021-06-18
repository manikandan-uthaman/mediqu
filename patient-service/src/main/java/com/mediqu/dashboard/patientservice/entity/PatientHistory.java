package com.mediqu.dashboard.patientservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "patient_history")
public class PatientHistory {
	
	@Id
	private Integer id;

	@Column(name = "patient_id")
	private Integer patientId;

	@Column(name = "doctor_id")
	private Integer doctorId;
	
	@Column(name = "visited_on")
	private Date visitedOn;
	
	private String diagnosis;
	private String notes;
	
	@Column(name = "bill_amount")
	private String billAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatient_id() {
		return patientId;
	}

	public void setPatient_id(Integer patient_id) {
		this.patientId = patient_id;
	}

	public Integer getDoctor_id() {
		return doctorId;
	}

	public void setDoctor_id(Integer doctor_id) {
		this.doctorId = doctor_id;
	}

	public Date getVisitedOn() {
		return visitedOn;
	}

	public void setVisitedOn(Date visitedOn) {
		this.visitedOn = visitedOn;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}
}
