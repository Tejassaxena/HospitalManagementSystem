package com.aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aop.pojo.ConsultantDetails;
import com.aop.service.ConsultantService;

@RestController
public class ConsultantController {
	@Autowired
	private ConsultantService service;

	@GetMapping("/cc")
	public ConsultantDetails get() {
		
		ConsultantDetails consultantDetails=new ConsultantDetails(12, "DD", (long) 123131231, "DD");

		return consultantDetails;
	}


	@GetMapping("/getAllConsultant")
	public List<ConsultantDetails> getAllConsultant() {
		return service.getAllConsultant();
	}

	// old
	@PostMapping("/createConsultant")
	public ConsultantDetails createConsultant(@RequestBody ConsultantDetails appointmentDetails) {
		return service.CreateConsultant(appointmentDetails);
	}

	@PutMapping("/updateConsultant")
	public ConsultantDetails updateConsultant(@RequestBody ConsultantDetails appointmentDetails) {

		return service.updateConsultant(appointmentDetails);
	}

	public ConsultantDetails getConsultantByID(Integer appointmentID) {
		return service.getConsultantByID(appointmentID);
	}

	public ConsultantDetails deleteConsultantByID(Integer appointmentID) {
		return service.deleteConsultantByID(appointmentID);
	}

}
