package com.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aop.dto.DoctorDetails;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorDetails, Integer> {
}
