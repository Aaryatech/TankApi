package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tankwebapi.work.model.GetWorkMonthDetails;

public interface GetWorkMonthDetailsRepo extends JpaRepository<GetWorkMonthDetails, Integer>{
	@Query(value = "SELECT\n" + 
			"    w.work_id,\n" + 
			"    MONTHNAME(w.work_date) AS month_name,\n" + 
			"    MONTH(w.work_date) AS month_date,\n" + 
			"    YEAR(w.work_date) AS year,\n" + 
			"    SUM(w.total_amt) AS total_amt,\n" + 
			"    SUM(w.disc_amt) AS disc_amt,\n" + 
			"    SUM(w.final_amt) AS final_amt\n" + 
			"FROM\n" + 
			"    t_work w\n" + 
			"WHERE\n" + 
			"    w.work_date BETWEEN :fromDate AND :toDate\n" + 
			"GROUP BY\n" + 
			"    MONTH(w.work_date)", nativeQuery = true)	
	List<GetWorkMonthDetails> getWorkDetailsByMonth(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
