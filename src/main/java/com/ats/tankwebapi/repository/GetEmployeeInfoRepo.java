package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.tankwebapi.work.model.GetEmployeeInfo;

public interface GetEmployeeInfoRepo extends JpaRepository<GetEmployeeInfo, Integer> {

	
	@Query(value = "SELECT w.*, c.customer_name,c.customer_address,c.customer_phone,c.customer_contact_name,c.customer_contact_number,"
			+ "u.user_name,u.date_of_birth ,u.designation,u.mobile_number"
			
			+ " FROM  t_work w,m_user u,\n" + 
			"   \n" + 
			"   m_customer c " 
			+ "WHERE w.work_date BETWEEN :fromDate AND :toDate \n" + 
			"   and w.employee_id  like  CONCAT('%',:empId,'%')\n" + 
			"   and  u.user_id =:empId and w.del_status=1 and \n" + 
			"     c.customer_id=w.customer_id ", nativeQuery = true)	
	List<GetEmployeeInfo> getEmpInfoByDate(int empId, String fromDate, String toDate);

	@Query(value = "SELECT  u.user_name  FROM m_user u WHERE u.user_id IN(:al) ", nativeQuery = true)
	List<String> getUserName(List<String> al);
	 
}
