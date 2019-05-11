package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tankwebapi.work.model.GetWorkDetail;

public interface WorkDetailRepo extends JpaRepository<GetWorkDetail, Integer>{

	@Query(value = "SELECT w.customer_id,w.work_date ,w.work_id,SUM(w.total_amt) as total_amt FROM t_work w WHERE w.del_status=1 and w.customer_id=:custId group by w.work_date", nativeQuery = true)
		List<GetWorkDetail> getTotalWorkAmtByCustId(@Param("custId") int custId);

}
