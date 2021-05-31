package com.g6.onlineeyecare.report.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.g6.onlineeyecare.patient.dto.Patient;
import com.g6.onlineeyecare.test.dto.Test;

@Entity
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reportId;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate dateOfReport;
	@Column
	@NotEmpty(message = "cannot be left empty")
	private String descriptionOfReport;
	@Column
	@NotEmpty(message = "cannot be left empty")
	private String visualAcuity;
	@Column
	@NotEmpty(message = "cannot be left empty")
	private String visualAcuityNear;
	@Column
	@NotEmpty(message = "cannot be left empty")
	private String visualAcuityDistance;
	
	@OneToOne(fetch = FetchType.EAGER,optional = true)
	@JoinColumn(name = "test_Id",referencedColumnName = "testId")
	@NotNull
	private Test    typeOfTest;
	
	@OneToOne(fetch = FetchType.EAGER,optional = true)
	@JoinColumn(name = "patient_Id",referencedColumnName = "userId")
	@NotNull
	private Patient patient;
	
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	
	public LocalDate getDateOfReport() {
		return dateOfReport;
	}
	public void setDateOfReport(LocalDate dateOfReport) {
		this.dateOfReport = dateOfReport;
	}
	public String getDescriptionOfReport() {
		return descriptionOfReport;
	}
	public void setDescriptionOfReport(String descriptionOfReport) {
		this.descriptionOfReport = descriptionOfReport;
	}
	public String getVisualAcuity() {
		return visualAcuity;
	}
	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}
	public String getVisualAcuityNear() {
		return visualAcuityNear;
	}
	public void setVisualAcuityNear(String visualAcuityNear) {
		this.visualAcuityNear = visualAcuityNear;
	}
	public String getVisualAcuityDistance() {
		return visualAcuityDistance;
	}
	public void setVisualAcuityDistance(String visualAcuityDistance) {
		this.visualAcuityDistance = visualAcuityDistance;
	}
	public Test getTypeOfTest() {
		return typeOfTest;
	}
	public void setTypeOfTest(Test typeOfTest) {
		this.typeOfTest = typeOfTest;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Report(int reportId, LocalDate dateOfReport, String descriptionOfReport, String visualAcuity,
			String visualAcuityNear, String visualAcuityDistance, Test typeOfTest, Patient patient) {
		super();
		this.reportId = reportId;
		this.dateOfReport = dateOfReport;
		this.descriptionOfReport = descriptionOfReport;
		this.visualAcuity = visualAcuity;
		this.visualAcuityNear = visualAcuityNear;
		this.visualAcuityDistance = visualAcuityDistance;
		this.typeOfTest = typeOfTest;
		this.patient = patient;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reportId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (reportId != other.reportId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", dateOfReport=" + dateOfReport + ", descriptionOfReport="
				+ descriptionOfReport + ", visualAcuity=" + visualAcuity + ", visualAcuityNear=" + visualAcuityNear
				+ ", visualAcuityDistance=" + visualAcuityDistance + ", typeOfTest=" + typeOfTest + ", patient="
				+ patient + "]";
	}
	
	
	
}
