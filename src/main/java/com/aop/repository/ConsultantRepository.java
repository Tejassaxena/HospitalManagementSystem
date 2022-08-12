package com.aop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aop.pojo.ConsultantDetails;

@Repository
public interface ConsultantRepository extends JpaRepository<ConsultantDetails, Integer> {

}
