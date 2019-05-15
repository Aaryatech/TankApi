package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tankwebapi.work.model.GetEmployeeInfo;

public interface GetEmployeeInfoRepo extends JpaRepository<GetEmployeeInfo, Integer> {

	
	@Query(value = "SELECT\n" + 
			"    @a\\:=@a+1 sr_no,"
			+ "   w.*,\n" + 
			"    u.user_id,\n" + 
			"    u.user_name,\n" + 
			"    u.date_of_birth,\n" + 
			"    u.designation,\n" + 
			"    u.mobile_number,\n" + 
			"    \n" + 
			"    c.customer_name,\n" + 
			"    c.customer_address,\n" + 
			"    c.customer_phone,\n" + 
			"    c.customer_contact_name,\n" + 
			"    c.customer_contact_number\n" + 
			"FROM\n" + 
			"    m_user u,\n" + 
			"    t_work w,\n" + 
			"    m_customer c,\n" + 
			"    (SELECT @a\\:= 0) AS a\n" + 
			"WHERE\n" + 
			"    u.user_id IN(\n" + 
			"SELECT\n" + 
			"   :empId \n" + 
			"FROM\n" + 
			"    t_work\n" + 
			") AND FIND_IN_SET(u.user_id,w.employee_id ) AND w.work_date BETWEEN :fromDate AND :toDate AND w.customer_id=c.customer_id\n" + 
			"", nativeQuery = true)	
	List<GetEmployeeInfo> getEmpInfoByDate(@Param("empId") int empId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value = "SELECT  u.user_name  FROM m_user u WHERE u.user_id IN(:al) ", nativeQuery = true)
	List<String> getUserName(List<String> al);

	@Query(value = "SELECT\n" + 
			"    @a\\:=@a+1 sr_no,"
			+ "   w.*,\n" + 
			"    u.user_id,\n" + 
			"    u.user_name,\n" + 
			"    u.date_of_birth,\n" + 
			"    u.designation,\n" + 
			"    u.mobile_number,\n" + 
			"    \n" + 
			"    c.customer_name,\n" + 
			"    c.customer_address,\n" + 
			"    c.customer_phone,\n" + 
			"    c.customer_contact_name,\n" + 
			"    c.customer_contact_number\n" + 
			"FROM\n" + 
			"    m_user u,\n" + 
			"    t_work w,\n" + 
			"    m_customer c,\n" + 
			"    (SELECT @a\\:= 0) AS a\n" + 
			"WHERE\n" + 
			"    u.user_id IN(\n" + 
			"SELECT\n" + 
			"    employee_id\n" + 
			"FROM\n" + 
			"    t_work\n" + 
			") AND FIND_IN_SET(u.user_id, w.employee_id) AND w.work_date BETWEEN :fromDate AND :toDate AND w.customer_id=c.customer_id\n" + 
			"", nativeQuery = true)	
	List<GetEmployeeInfo> getEmpInfoByFromDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	  
}
