package com.intellect.mongo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Patient {

	@Id
	private String patientId;
	private String patientName;
	private int patientAge;
	private String patientContactNo;
	private LocalDateTime appointmentDate=LocalDateTime.now();

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Patient(String patientName, int patientAge, String patientContactNo, LocalDateTime appointmentDate) {
		super();
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientContactNo = patientContactNo;
		this.appointmentDate = LocalDateTime.now();
	}


	public Patient(String patientId, String patientName, int patientAge, String patientContactNo,
			LocalDateTime appointmentDate) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientContactNo = patientContactNo;
		this.appointmentDate = LocalDateTime.now();
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientContactNo() {
		return patientContactNo;
	}

	public void setPatientContactNo(String patientContactNo) {
		this.patientContactNo = patientContactNo;
	}

	public LocalDateTime getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDate = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientContactNo=" + patientContactNo + ", appointmentDate=" + appointmentDate + "]";
	}

}
