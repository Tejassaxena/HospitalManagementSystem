package com.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.aop.pojo.AppDetailsReq;
import com.aop.pojo.DoctorDetails;
import com.aop.pojo.PatientDetails;

@Controller
public class TestController {
	@Autowired
	private RestTemplate rt;

	@GetMapping("/getDoctorByIDNew")
	public ModelAndView getForm() {
		System.out.println("TestController.getForm()");
		ModelAndView mav = new ModelAndView();
		try {
			DoctorDetails existedDoctor = rt
					.getForEntity("http://localhost:3333/getDoctorByID/" + 11, DoctorDetails.class).getBody();
			AppDetailsReq req = new AppDetailsReq();
			req.setDocID(11);
			req.setReqID(11);
			PatientDetails patient = new PatientDetails();
			mav.addObject("existedDoctor", existedDoctor);
			mav.addObject("appDetailRequest", req);
			mav.addObject("patient", patient);
			mav.setViewName("BookApointmentPage");
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return mav;
	}

//	@PostMapping("/bookAppointmentByDocIDNew")
	public ModelAndView bookAppointmentByDocID(@ModelAttribute AppDetailsReq req) {
		System.out.println("TestController.bookAppointmentByDocID()");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Dashboard");
		return mav;
	}
}
