package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tankwebapi.work.model.GetCustomerDetails;

public interface GetCustomerDetailsRepo extends JpaRepository<GetCustomerDetails, Integer>{

	@Query(value = "SELECT\n" + 
			"    c.*,\n" + 
			"    (select SUM(w.total_amt) from t_work w WHERE  c.customer_id = w.customer_id) AS work_amt ,\n" + 
			"   (select SUM(p.cost_rs) from t_payment p WHERE c.customer_id = p.customer_id)AS pay_amt \n" + 
			"FROM\n" + 
			"    m_customer c WHERE c.del_status=1 AND (select SUM(w.total_amt) from t_work w WHERE  c.customer_id = w.customer_id)  >  (select SUM(p.cost_rs) from t_payment p WHERE c.customer_id = p.customer_id) \n" + 
			"    ORDER BY ((select SUM(w.total_amt) from t_work w WHERE  c.customer_id = w.customer_id)  -  (select SUM(p.cost_rs) from t_payment p WHERE c.customer_id = p.customer_id)) DESC", nativeQuery = true)	
	List<GetCustomerDetails> getCustomerInfoByAmtDesc();
	
	@Query(value = "   SELECT\n" + 
			"        c.*,\n" + 
			"        COALESCE(\n" + 
			"        (select\n" + 
			"            SUM(w.total_amt) \n" + 
			"        from\n" + 
			"            t_work w \n" + 
			"        WHERE\n" + 
			"            c.customer_id = w.customer_id),0) AS work_amt ,\n" + 
			"          COALESCE((select\n" + 
			"            SUM(p.cost_rs) \n" + 
			"        from\n" + 
			"            t_payment p \n" + 
			"        WHERE\n" + 
			"            c.customer_id = p.customer_id),0)AS pay_amt  \n" + 
			"    FROM\n" + 
			"        m_customer c\n" + 
			"    WHERE\n" + 
			"        c.del_status=1 \n" + 
			"        AND c.area_id=:areaId GROUP BY c.customer_id\n" + 
			"     \n" + 
			"      ", nativeQuery = true)	
	List<GetCustomerDetails> getCustomerWiseReportByAreaId(@Param("areaId") int areaId);

	@Query(value = "   SELECT\n" + 
			"        c.*,\n" + 
			"        COALESCE(\n" + 
			"        (select\n" + 
			"            SUM(w.total_amt) \n" + 
			"        from\n" + 
			"            t_work w \n" + 
			"        WHERE\n" + 
			"            c.customer_id = w.customer_id),0) AS work_amt ,\n" + 
			"          COALESCE((select\n" + 
			"            SUM(p.cost_rs) \n" + 
			"        from\n" + 
			"            t_payment p \n" + 
			"        WHERE\n" + 
			"            c.customer_id = p.customer_id),0)AS pay_amt  \n" + 
			"    FROM\n" + 
			"        m_customer c\n" + 
			"    WHERE\n" + 
			"        c.del_status=1 \n" + 
			"      \n" + 
			"     \n" + 
			"      ", nativeQuery = true)
	List<GetCustomerDetails> getCustomerWiseReport();
}

/*
 * SELECT COALESCE( ( SELECT SUM(w.total_amt) FROM t_work w WHERE w.customer_id
 * = 1 GROUP BY w.work_date ), 0 ) AS work_amt, COALESCE( ( SELECT
 * SUM(p.cost_rs) FROM t_payment p WHERE p.customer_id = 1 GROUP BY
 * p.payment_date ), 0 ) AS pay_amt
 * 
 * SELECT w.customer_id,w.work_date ,SUM(w.total_amt) as total_amt FROM t_work w WHERE w.del_status=1 group by w.work_date and w.customer_id=1
 */