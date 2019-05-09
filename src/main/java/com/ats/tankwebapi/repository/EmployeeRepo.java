package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tankwebapi.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	List<Employee> findByOrderByCustomerIdDesc();

}
