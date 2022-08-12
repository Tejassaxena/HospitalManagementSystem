package com.aop.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.aop.pojo.AppointMentDetails;
import com.aop.pojo.AppointmentRequest;
import com.aop.pojo.ConsultantDetails;
import com.aop.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository repo;

	public AppointMentDetails bookAppointment(@RequestBody AppointmentRequest req) {
		AppointMentDetails appointMentDetails = new AppointMentDetails();
		ConsultantDetails consultantDetails = new ConsultantDetails();

		return CreateAppointment(appointMentDetails);
	}

	public AppointMentDetails CreateAppointment(AppointMentDetails appointmentDetails) {
		AppointMentDetails save = null;
		try {
			save = repo.save(appointmentDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return save;
	}

	public AppointMentDetails updateAppointment(AppointMentDetails appointmentDetails) {
		Optional<AppointMentDetails> existedAppointment = repo.findById(appointmentDetails.getAppID());
		if (existedAppointment.isPresent()) {
			AppointMentDetails updatedAppointment = existedAppointment.get();
			updatedAppointment.setConsID(appointmentDetails.getConsID());
			updatedAppointment.setSession(appointmentDetails.getSession());
			updatedAppointment.setSlots(appointmentDetails.getSlots());
			updatedAppointment.setStatus(appointmentDetails.getStatus());
			return updatedAppointment;
		} else
			return null;
	}

	public AppointMentDetails getAppointmentByID(Integer appointmentID) {
		Optional<AppointMentDetails> existedAppointment = repo.findById(appointmentID);
		if (existedAppointment.isPresent()) {
			return existedAppointment.get();
		} else
			return null;
	}

	public AppointMentDetails deleteAppointmentByID(Integer appointmentID) {
		Optional<AppointMentDetails> existedAppointment = repo.findById(appointmentID);
		if (existedAppointment.isPresent()) {
			return existedAppointment.get();
		} else
			return null;
	}

	public List<AppointMentDetails> getAllAppointment() {
		return repo.findAll();
	}

//	public List<AppointMentDetails> getDoctorsAppointment(Integer docID) {
//		List<AppointMentDetails> all = getAllAppointment();
//
//		return all.stream().filter(app -> app.getDoctorID() == docID).collect(Collectors.toList());
//	}

}
