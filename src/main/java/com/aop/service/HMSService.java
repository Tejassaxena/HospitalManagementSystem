package com.aop.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.aop.dto.AppointmentDetails;
import com.aop.pojo.AppDetailsReq;
import com.aop.pojo.AppDetailsResponse;
import com.aop.pojo.DoctorDetails;
import com.aop.pojo.PatientDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HMSService {
	@Autowired
	private RestTemplate rt;

	public void bookAppointmentByDocIDNew(AppDetailsReq appDetailsRequest) throws JsonProcessingException {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<AppDetailsReq> entity = new HttpEntity<AppDetailsReq>(headers);
		// doctor service
		System.out.println("Request: " + new ObjectMapper().writeValueAsString(appDetailsRequest));
		AppDetailsResponse existedDoctor = rt.postForObject("http://localhost:3333/bookAppointmentByDocID",
				appDetailsRequest, AppDetailsResponse.class);

	}

	public List<AppointmentDetails> getDoctorsAppointment(Integer docID) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<AppDetailsReq> entity = new HttpEntity<AppDetailsReq>(headers);
		// appointment service
		ResponseEntity<AppointmentDetails[]> existedDoctor = rt
				.getForEntity("http://localhost:6666/getDoctorsAppointment/" + docID, AppointmentDetails[].class);
		List<AppointmentDetails> docIDPatients = Arrays.stream(existedDoctor.getBody()).map(app -> app)
				.collect(Collectors.toList());
		return docIDPatients;
	}

}
