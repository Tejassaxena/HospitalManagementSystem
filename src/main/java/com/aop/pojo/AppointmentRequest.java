package com.aop.pojo;

import org.springframework.stereotype.Component;

@Component
public class AppointmentRequest {
	private int reqID;
	private int consName;
	private String patientName;
	private AppointMentDetails appDetails;
	private PatientDetails patientDetails;

	public PatientDetails getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
	}

	public int getReqID() {
		return reqID;
	}

	public void setReqID(int reqID) {
		this.reqID = reqID;
	}

	public int getConsName() {
		return consName;
	}

	public void setConsName(int consName) {
		this.consName = consName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public AppointMentDetails getAppDetails() {
		return appDetails;
	}

	public void setAppDetails(AppointMentDetails appDetails) {
		this.appDetails = appDetails;
	}
}
