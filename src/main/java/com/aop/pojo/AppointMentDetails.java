package com.aop.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AppointmentDetails")
public class AppointMentDetails {
	@Id
	@Column(name = "appID")
	private int appID;
	private int consID;
	private String slots;
	private String session;
	private String status;

	public AppointMentDetails(int appID, int consID, String slots, String session, String status) {
		super();
		this.appID = appID;
		this.consID = consID;
		this.slots = slots;
		this.session = session;
		this.status = status;
	}

	public AppointMentDetails() {
		// TODO Auto-generated constructor stub
	}

	public int getAppID() {
		return appID;
	}

	public void setAppID(int appID) {
		this.appID = appID;
	}

	public int getConsID() {
		return consID;
	}

	public void setConsID(int consID) {
		this.consID = consID;
	}

	public String getSlots() {
		return slots;
	}

	public void setSlots(String slots) {
		this.slots = slots;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AppointMentDetails [appID=" + appID + ", consID=" + consID + ", slots=" + slots + ", session=" + session
				+ ", status=" + status + "]";
	}




}