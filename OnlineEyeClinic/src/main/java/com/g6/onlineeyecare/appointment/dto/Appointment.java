package com.g6.onlineeyecare.appointment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.g6.onlineeyecare.doctor.dto.Doctor;
import com.g6.onlineeyecare.patient.dto.Patient;

@Entity
@Table(name = "Appointment_info")
public class Appointment {

	//comment
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private LocalDate appointmentDate;
	
	@Column
	@NotNull
	private LocalTime appointmentTime;
	
	@OneToOne
	@JoinColumn(name ="doctor_Id",referencedColumnName = "userId")
	private Doctor doctor;
	
	@OneToOne
	@JoinColumn(name = "patient_Id",referencedColumnName = "userId")
	private Patient patient;
	
	public Appointment() {
		super();
		
	}
	public Appointment(int appointmentId, LocalDate appointmentDate, LocalTime appointmentTime, Doctor doctor,
			Patient patient) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.doctor = doctor;
		this.patient = patient;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appointmentId;
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
		Appointment other = (Appointment) obj;
		if (appointmentId != other.appointmentId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate
				+ ", appointmentTime=" + appointmentTime + ", doctor=" + doctor + ", patient=" + patient + "]";
	}
	
	
}
