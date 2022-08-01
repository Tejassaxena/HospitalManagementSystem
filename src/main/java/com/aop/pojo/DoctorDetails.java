package com.aop.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aop.dto.AppointmentDetails;
@Component
public class DoctorDetails {
	public Integer doctorID;
	public String doctorName;
	public Long doctorContact;
	public String role;
//
	private List<AppointmentDetails> appointmentsList;

	private List<PatientDetails> patientList;

	public DoctorDetails() {
	}

	public DoctorDetails(Integer doctorID, String doctorName, Long doctorContact,String role) {
		super();
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.doctorContact = doctorContact;
		this.role = role;
	}






	public DoctorDetails(Integer doctorID, String doctorName, Long doctorContact, 
			List<AppointmentDetails> appointmentsList, List<PatientDetails> patientList,String role) {
		super();
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.doctorContact = doctorContact;
		this.role = role;
		this.appointmentsList = appointmentsList;
		this.patientList = patientList;
	}


	public List<AppointmentDetails> getAppointmentsList() {
		return appointmentsList;
	}

	public void setAppointmentsList(List<AppointmentDetails> appointmentsList) {
		this.appointmentsList = appointmentsList;
	}

	public List<PatientDetails> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<PatientDetails> patientList) {
		this.patientList = patientList;
	}

	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public Integer getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(Integer doctorID) {
		this.doctorID = doctorID;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Long getDoctorContact() {
		return doctorContact;
	}

	public void setDoctorContact(Long doctorContact) {
		this.doctorContact = doctorContact;
	}

	@Override
	public String toString() {
		return "DoctorDetails [doctorID=" + doctorID + ", doctorName=" + doctorName + ", doctorContact=" + doctorContact
				+ ", role=" + role + ", appointmentsList=" + appointmentsList + ", patientList=" + patientList + "]";
	}






}