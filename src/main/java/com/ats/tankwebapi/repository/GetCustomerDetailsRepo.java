package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.tankwebapi.work.model.GetCustomerDetails;

public interface GetCustomerDetailsRepo extends JpaRepository<GetCustomerDetails, Integer>{

	@Query(value = "SELECT\n" + 
			"    c.*,\n" + 
			"    (select SUM(w.total_amt) from t_work w WHERE  c.customer_id = w.customer_id) AS work_amt ,\n" + 
			"   (select SUM(p.cost_rs) from t_payment p WHERE c.customer_id = p.customer_id)AS pay_amt \n" + 
			"FROM\n" + 
			"    m_customer c WHERE c.del_status=1 AND (select SUM(w.total_amt) from t_work w WHERE  c.customer_id = w.customer_id)  >    (select SUM(p.cost_rs) from t_payment p WHERE c.customer_id = p.customer_id) \n" + 
			"    ORDER BY ((select SUM(w.total_amt) from t_work w WHERE  c.customer_id = w.customer_id)  -  (select SUM(p.cost_rs) from t_payment p WHERE c.customer_id = p.customer_id)) DESC", nativeQuery = true)	
	List<GetCustomerDetails> getCustomerInfoByAmtDesc();

}

/*
 * SELECT COALESCE( ( SELECT SUM(w.total_amt) FROM t_work w WHERE w.customer_id
 * = 1 GROUP BY w.work_date ), 0 ) AS work_amt, COALESCE( ( SELECT
 * SUM(p.cost_rs) FROM t_payment p WHERE p.customer_id = 1 GROUP BY
 * p.payment_date ), 0 ) AS pay_amt
 * 
 * SELECT w.customer_id,w.work_date ,SUM(w.total_amt) as total_amt FROM t_work w WHERE w.del_status=1 group by w.work_date and w.customer_id=1
 */