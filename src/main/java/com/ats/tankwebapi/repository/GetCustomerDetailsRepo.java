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
