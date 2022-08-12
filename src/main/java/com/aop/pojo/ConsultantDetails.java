package com.aop.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ConsultantDetails")
public class ConsultantDetails {
	@Id
	@Column(name = "consID")
	public Integer consID;
	public String consName;
	public Long consContact;
	public String speciality;

	public ConsultantDetails() {
		// TODO Auto-generated constructor stub
	}

	public ConsultantDetails(Integer consID, String consName, Long consContact, String speciality) {
	super();
	this.consID = consID;
	this.consName = consName;
	this.consContact = consContact;
	this.speciality = speciality;
}


	public Integer getConsID() {
		return consID;
	}

	public void setConsID(Integer consID) {
		this.consID = consID;
	}

	public String getConsName() {
		return consName;
	}

	public void setConsName(String consName) {
		this.consName = consName;
	}

	public Long getConsContact() {
		return consContact;
	}

	public void setConsContact(Long consContact) {
		this.consContact = consContact;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	

}
