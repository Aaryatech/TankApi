package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tankwebapi.work.model.GetWorkCustomer;

public interface GetWorkCustomerRepo extends JpaRepository<GetWorkCustomer, Integer>{

	@Query(value = " SELECT w.*,c.customer_name,c.customer_address,c.customer_phone,c.customer_contact_name,c.customer_contact_number"
			+ " FROM t_work w, m_customer c "
			+ "WHERE w.customer_id=c.customer_id and w.status=:status and w.del_status=1", nativeQuery = true)
	List<GetWorkCustomer> getAllworkInfo(@Param("status") int status);

	
	
	@Query(value = " SELECT w.*,c.customer_name,c.customer_address,c.customer_phone,c.customer_contact_name,c.customer_contact_number"
			+ " FROM t_work w, m_customer c "
			+ "WHERE w.customer_id=c.customer_id and DATE(w.next_date) < DATE(NOW()) and w.status=:status and c.del_status=1  and c.is_used=1", nativeQuery = true)
	List<GetWorkCustomer> getAllworkInfoSchedule(@Param("status") int status);


	@Query(value = " SELECT w.*,c.customer_name,c.customer_address,c.customer_phone,c.customer_contact_name,c.customer_contact_number"
			+ " FROM t_work w, m_customer c " 
			+ "WHERE w.customer_id=c.customer_id and w.work_date BETWEEN :fromDate AND :toDate and w.status IN(:status) and w.customer_id=:custId and c.del_status=1  and c.is_used=1", nativeQuery = true)
	List<GetWorkCustomer> getAllworkHistory(@Param("custId")int custId , @Param("status") List<Integer> status ,@Param("fromDate") String fromDate,@Param("toDate") String toDate);


	@Query(value = " SELECT w.*,c.customer_name,c.customer_address,c.customer_phone,c.customer_contact_name,c.customer_contact_number"
			+ " FROM t_work w, m_customer c " 
			+ "WHERE w.customer_id=c.customer_id and w.work_date BETWEEN :fromDate AND :toDate and w.status IN(:status) and w.customer_id=c.customer_id and c.del_status=1  and c.is_used=1", nativeQuery = true)
	List<GetWorkCustomer> getAllWorkHistoryByDate(List<Integer> status, String fromDate, String toDate);

	@Query(value = " SELECT w.*,c.customer_name,c.customer_address,c.customer_phone,c.customer_contact_name,c.customer_contact_number"
			+ " FROM t_work w, m_customer c " 
			+ "WHERE w.customer_id=c.customer_id and w.work_date BETWEEN :fromDate AND :toDate and c.del_status=1 ", nativeQuery = true)	
	List<GetWorkCustomer> getWorkListByDate(String fromDate, String toDate);

}
