package com.aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aop.pojo.AppointMentDetails;
import com.aop.pojo.AppointmentRequest;
import com.aop.pojo.ConsultantDetails;
import com.aop.service.AppointmentService;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentService service;

	@GetMapping("/gg")
	public AppointMentDetails get() {
		AppointMentDetails obj1 = new AppointMentDetails();
		
		AppointMentDetails appointMentDetails = new AppointMentDetails(12,12,"SS", "Mornig", "Free");
		ConsultantDetails consultantDetails=new ConsultantDetails(12, "DD", (long) 123131231, "DD", appointMentDetails);
		obj1.setConsDetails(consultantDetails);

		return obj1;
	}

	// new
	@PostMapping("/bookAppointment")
	public AppointMentDetails bookAppointment(@RequestBody AppointmentRequest req) {
		return service.bookAppointment(req);
	}

	@GetMapping("/getAllAppointment")
	public List<AppointMentDetails> getAllAppointment() {
		return service.getAllAppointment();
	}

	// old
	@PostMapping("/createAppointment")
	public AppointMentDetails createAppointment(@RequestBody AppointMentDetails appointmentDetails) {
		return service.CreateAppointment(appointmentDetails);
	}

	@PutMapping("/updateAppointment")
	public AppointMentDetails updateAppointment(@RequestBody AppointMentDetails appointmentDetails) {

		return service.updateAppointment(appointmentDetails);
	}

	public AppointMentDetails getAppointmentByID(Integer appointmentID) {
		return service.getAppointmentByID(appointmentID);
	}

	public AppointMentDetails deleteAppointmentByID(Integer appointmentID) {
		return service.deleteAppointmentByID(appointmentID);
	}

}
