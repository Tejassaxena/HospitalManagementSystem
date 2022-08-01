package com.aop.pojo;

public class AppDetailsReq {
	private int reqID;
	private int docID;
	private Integer patientID;
	private String patientName;
	private String address;
	private Long contact;
	private Integer age;
	private Integer weight;
	private String role;

	public Integer getPatientID() {
		return patientID;
	}

	public void setPatientID(Integer patientID) {
		this.patientID = patientID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AppDetailsReq() {
		// TODO Auto-generated constructor stub
	}

	public AppDetailsReq(int reqID, int docID, Integer patientID, String patientName, String address, Long contact,
			Integer age, Integer weight, String role) {
		super();
		this.reqID = reqID;
		this.docID = docID;
		this.patientID = patientID;
		this.patientName = patientName;
		this.address = address;
		this.contact = contact;
		this.age = age;
		this.weight = weight;
		this.role = role;
	}

	public int getReqID() {
		return reqID;
	}

	public void setReqID(int reqID) {
		this.reqID = reqID;
	}

	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}

}
