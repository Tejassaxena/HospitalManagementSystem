package com.aop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.aop.dto.AppointmentDetails;
import com.aop.dto.DoctorDetails;
import com.aop.dto.PatientDetails;
import com.aop.pojo.AppDetailsReq;
import com.aop.pojo.AppDetailsResponse;
import com.aop.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository repo;

	public DoctorDetails CreateDoctor(DoctorDetails doctorDetails) {
		return repo.save(doctorDetails);
	}

	public AppDetailsResponse bookAppointmentByDocID(@RequestBody AppDetailsReq appDetails) {
		DoctorDetails doctor = null;
		AppDetailsResponse response = null;
		Optional<DoctorDetails> existedDocter = repo.findById(appDetails.getDocID());
		if (existedDocter.isPresent())
			doctor = existedDocter.get();

		List<PatientDetails> patientList = doctor.getPatientList();
		PatientDetails newPatient = new PatientDetails(appDetails.getPatientID(),
				appDetails.getPatientName(), appDetails.getAddress(),
				appDetails.getContact(), appDetails.getAge(),
				appDetails.getWeight(), "P");
//		PatientDetails newPatient = new PatientDetails(appDetails.getPatientID(), appDetails.getPatientName(),
//				appDetails.getAddress(), appDetails.getContact(), appDetails.getReqID(), "D");

		patientList.add(newPatient);
		doctor.setPatientList(patientList);
		DoctorDetails doctorSaved = repo.save(doctor);
		if (doctorSaved != null) {
			response = new AppDetailsResponse(appDetails.getReqID(), appDetails.getDocID(), newPatient,
					"saved Successfully");
		} else
			response = new AppDetailsResponse(appDetails.getReqID(), appDetails.getDocID(), null, "Not saved");

		return response;
	}

	public DoctorDetails updateDoctor(DoctorDetails doctorDetails) {
		Optional<DoctorDetails> existedDoctor = repo.findById(doctorDetails.getDoctorID());
		if (existedDoctor.isPresent()) {
			DoctorDetails updatedDoctor = existedDoctor.get();
//			updatedDoctor.setDoctorID(doctorDetails.getDoctorID());
//			updatedDoctor.setDoctorID(doctorDetails.getDoctorID());
//			updatedDoctor.setPatientID(doctorDetails.getPatientList());
			return updatedDoctor;
		} else
			return null;
	}

	public DoctorDetails getDoctorByID(Integer doctorID) {
		Optional<DoctorDetails> existedDoctor = repo.findById(doctorID);
		if (existedDoctor.isPresent()) {
			return existedDoctor.get();
		} else
			return null;
	}

	public DoctorDetails deleteDoctorByID(Integer doctorID) {
		Optional<DoctorDetails> existedDoctor = repo.findById(doctorID);
		if (existedDoctor.isPresent()) {
			return existedDoctor.get();
		} else
			return null;
	}

	public List<DoctorDetails> getAllDoctor() {
		return repo.findAll();
	}

	public List<AppointmentDetails> listOfAppointments(Integer id) {
		List<DoctorDetails> allDoctor = getAllDoctor();
		return getAllApointmentsOfDoctor(id, allDoctor);

	}

	private List<AppointmentDetails> getAllApointmentsOfDoctor(Integer id, List<DoctorDetails> allDoctor) {
		List<com.aop.dto.AppointmentDetails> list = null;

		for (DoctorDetails doctorDetails : allDoctor) {
			if (doctorDetails.getDoctorID() == id)
				list = doctorDetails.getAppointmentsList();
		}
		return list;

	}
}
