package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tankwebapi.work.model.GetCustomerInfo;
import com.ats.tankwebapi.work.model.GetWorkCustomer;

public interface GetCustomerInfoRepo extends JpaRepository<GetCustomerInfo, Integer>{
	
	
	@Query(value = " SELECT c.*,p.payment_date,p.cost_rs,w.work_date,w.total_amt "
			+ "FROM t_work w, m_customer c, t_payment p "
			+ "WHERE w.customer_id=c.customer_id and c.customer_id=p.customer_id and c.customer_id =:custId and c.del_status=1", nativeQuery = true)
	List<GetCustomerInfo> getAllCustInfoPayment(int custId);

}
