package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tankwebapi.model.Customer;
import com.ats.tankwebapi.model.Work;

public interface WorkRepo extends JpaRepository<Work, Integer>{

	List<Work> findByStatusAndDelStatus(int status, int i);


}
