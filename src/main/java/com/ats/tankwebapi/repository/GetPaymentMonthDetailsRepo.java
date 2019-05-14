package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tankwebapi.work.model.GetPaymentMonthDetails;

public interface GetPaymentMonthDetailsRepo extends JpaRepository<GetPaymentMonthDetails, Integer>{
	@Query(value = "SELECT\n" + 
			"    p.payment_id,\n" + 
			"    MONTHNAME(p.payment_date) AS month_name,\n" + 
			"    MONTH(p.payment_date) AS month_date,\n" + 
			"    YEAR(p.payment_date) AS year,\n" + 
			"    SUM(p.cost_rs) AS cost_rs\n" + 
		
			"FROM\n" + 
			"    t_payment as  p\n" + 
			"WHERE\n" + 
			"    p.payment_date BETWEEN :fromDate AND :toDate\n" + 
			"GROUP BY\n" + 
			"    MONTH(p.payment_date)", nativeQuery = true)	
	List<GetPaymentMonthDetails> getPaymentDetailsByMonth(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
}
