package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tankwebapi.work.model.GetPaymentDetail;


public interface GetPaymentDetailRepo  extends JpaRepository<GetPaymentDetail, Integer>{
	@Query(value = "SELECT p.payment_date,p.payment_id,p.customer_id,SUM(p.cost_rs) as cost_rs from t_payment as p where p.customer_id=:custId GROUP BY p.payment_date", nativeQuery = true)
	List<GetPaymentDetail> getTotalPaymentAmtByCustId(@Param("custId") int custId);

}
