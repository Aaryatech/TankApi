package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tankwebapi.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	List<Customer> findByOrderByCustomerIdDesc();

	Customer findByCustomerIdOrderByCustomerIdDesc(int userId);

	@Transactional
	@Modifying
	@Query("update Customer set del_status=0  WHERE customer_id=:custId")
	int deleteCustomer(int custId);

	List<Customer> findByAreaIdAndDelStatus(int custId,int i);

	Customer findByCustomerIdAndDelStatusOrderByCustomerIdDesc(int custId, int i);

	List<Customer> findByDelStatusOrderByCustomerIdDesc(int i);

	List<Customer> findByDelStatusAndIsUsedOrderByCustomerIdDesc(int i, int j);

	List<Customer> findByDelStatusAndIsUsed(int i, int j);

	 

}
