package com.aop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aop.pojo.ConsultantDetails;
import com.aop.repository.ConsultantRepository;

@Service
public class ConsultantService {

	@Autowired
	private ConsultantRepository repo;


	public ConsultantDetails CreateConsultant(ConsultantDetails consultantDetails) {
		ConsultantDetails save = null;
		try {
			save = repo.save(consultantDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return save;
	}

	public ConsultantDetails updateConsultant(ConsultantDetails consultantDetails) {
		Optional<ConsultantDetails> existedConsultant = repo.findById(consultantDetails.getConsID());
		if (existedConsultant.isPresent()) {
			ConsultantDetails updatedConsultant = existedConsultant.get();
			updatedConsultant.setConsID(consultantDetails.getConsID());
			updatedConsultant.setConsContact(consultantDetails.getConsContact());
			updatedConsultant.setConsName(consultantDetails.getConsName());
			return updatedConsultant;
		} else
			return null;
	}

	public ConsultantDetails getConsultantByID(Integer appointmentID) {
		Optional<ConsultantDetails> existedConsultant = repo.findById(appointmentID);
		if (existedConsultant.isPresent()) {
			return existedConsultant.get();
		} else
			return null;
	}

	public ConsultantDetails deleteConsultantByID(Integer appointmentID) {
		Optional<ConsultantDetails> existedConsultant = repo.findById(appointmentID);
		if (existedConsultant.isPresent()) {
			return existedConsultant.get();
		} else
			return null;
	}

	public List<ConsultantDetails> getAllConsultant() {
		return repo.findAll();
	}

//	public List<ConsultantDetails> getDoctorsConsultant(Integer docID) {
//		List<ConsultantDetails> all = getAllConsultant();
//
//		return all.stream().filter(app -> app.getDoctorID() == docID).collect(Collectors.toList());
//	}

}
