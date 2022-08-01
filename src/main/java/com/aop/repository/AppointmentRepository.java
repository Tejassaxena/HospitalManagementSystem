package com.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aop.dto.AppointmentDetails;


@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentDetails, Integer> {

}
