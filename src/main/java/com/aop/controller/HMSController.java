package com.aop.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.aop.dto.AppointmentDetails;
import com.aop.dto.DoctorDetails;
import com.aop.pojo.AppDetailsReq;
import com.aop.pojo.PatientDetails;
import com.aop.service.AppointmentService;
import com.aop.service.DoctorService;
import com.aop.service.HMSService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class HMSController {
	@Autowired
	private RestTemplate rt;
	@Autowired
	private DoctorService doctorService;

	@Autowired
	private HMSService service;
	@Autowired
	private AppointmentService appService;

	@GetMapping("/")
	public String getHomePage() {
		return "HomePage";
	}

	@GetMapping("/logout")
	public String logout() {
		return "LogoutPage";
	}

	@PostMapping("/authenticate")
	public String goToDashbiard(HttpServletRequest req) {
		String pageName = "";
		if (req.getParameter("uname").equalsIgnoreCase("user") && req.getParameter("psw").equalsIgnoreCase("user"))
			pageName = "DashboardPatient";
		else if (req.getParameter("uname").equalsIgnoreCase("admin")
				&& req.getParameter("psw").equalsIgnoreCase("admin"))
			pageName = "DashboardDoctor";
		else
			pageName = "LoginFaildPage";
		return pageName;
	}

	@GetMapping("/goToDashboardDoctor")
	public String getDoctorDashboard() {
		return "DashboardDoctor";
	}

	@GetMapping("/goToDashboardPatient")
	public String getDashboardPatient() {
		return "DashboardPatient";
	}

	@GetMapping("/getDoctors")
	public ModelAndView getDoctorList() {
		ModelAndView mav = new ModelAndView();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		List<DoctorDetails> list = rt.exchange("http://localhost:3333/getAllDoctor", HttpMethod.GET, entity, List.class)
//				.getBody();
		List<DoctorDetails> list = doctorService.getAllDoctor();
		mav.addObject("doctorsList", list);
		mav.setViewName("DoctorsList");
		return mav;
	}

	@GetMapping("/getDoctorByID/{doctorID}")
	public ModelAndView getDoctorByID(@PathVariable("doctorID") Integer docID) {
		ModelAndView mav = new ModelAndView();
		try {
//			DoctorDetails existedDoctor = rt
//					.getForEntity("http://localhost:3333/getDoctorByID/" + docID, DoctorDetails.class).getBody();
			DoctorDetails existedDoctor = doctorService.getDoctorByID(docID);
			AppDetailsReq appDetailsRequest = new AppDetailsReq();
			appDetailsRequest.setDocID(docID);
			appDetailsRequest.setReqID(docID);
			PatientDetails patient = new PatientDetails();
			mav.addObject("existedDoctor", existedDoctor);
			mav.addObject("appDetailRequest", appDetailsRequest);
			mav.addObject("patient", patient);
			mav.setViewName("BookApointmentPage");
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return mav;
	}

	@PostMapping("/bookAppointmentByDocID")
	public ModelAndView bookAppointmentByDocID(@ModelAttribute AppDetailsReq appDetailsRequest) {
		//			service.bookAppointmentByDocIDNew(appDetailsRequest);
		doctorService.bookAppointmentByDocID(appDetailsRequest);
		return new ModelAndView("AppointmentSuccessPage");
	}

	@GetMapping("/loadDoctorIDPage")
	public String loadDoctorIDPage() {
		return "GetDoctorIDPage";
	}

	@PostMapping("/getDoctorsAppointment")
	public ModelAndView getDoctorsAppointment(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
//		List<AppointmentDetails> doctorsAppointment = service
//				.getDoctorsAppointment(Integer.valueOf(req.getParameter("doctorID")));
		
		List<AppointmentDetails> doctorsAppointment=appService.getDoctorsAppointment(Integer.valueOf(req.getParameter("doctorID")));
		if(doctorsAppointment.size()!=0)
			mav.setViewName("PatientsByDocID");
		else 
			mav.setViewName("PatientsByDocID");
			mav.addObject("appointmentList", doctorsAppointment);
			mav.addObject("appointmentList", doctorsAppointment);
		return mav;
	}
}