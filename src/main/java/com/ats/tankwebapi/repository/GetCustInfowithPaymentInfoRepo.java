package com.ats.tankwebapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.tankwebapi.work.model.GetCustInfowithPaymentInfo;

public interface GetCustInfowithPaymentInfoRepo extends JpaRepository<GetCustInfowithPaymentInfo, Integer>{
	
	@Query(value = " SELECT p.*,c.customer_name,c.customer_address,c.customer_phone,c.customer_contact_name,c.customer_contact_number"
			+ " FROM t_payment p, m_customer c " 
			+ "WHERE p.customer_id=c.customer_id and p.payment_date BETWEEN :fromDate AND :toDate and c.del_status=1 ", nativeQuery = true)	
	List<GetCustInfowithPaymentInfo> getPaymentListByDate(String fromDate, String toDate);
}
