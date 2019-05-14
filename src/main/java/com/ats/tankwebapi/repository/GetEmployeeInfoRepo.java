package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.tankwebapi.work.model.GetEmployeeInfo;

public interface GetEmployeeInfoRepo extends JpaRepository<GetEmployeeInfo, Integer> {

	
	@Query(value = "SELECT w.*, c.customer_name,c.customer_address,c.customer_phone,c.customer_contact_name,c.customer_contact_number"
			
			+ " FROM  t_work w,\n" + 
			"   \n" + 
			"   m_customer c " 
			+ "WHERE w.work_date BETWEEN :fromDate AND :toDate \n" + 
			"   and w.employee_id  like  CONCAT('%',:empId,'%')\n" + 
			"   and  w.del_status=1 and \n" + 
			"     c.customer_id=w.customer_id ", nativeQuery = true)	
	List<GetEmployeeInfo> getEmpInfoByDate(int empId, String fromDate, String toDate);

	@Query(value = "SELECT  u.user_name  FROM m_user u WHERE u.user_id IN(:al) ", nativeQuery = true)
	List<String> getUserName(List<String> al);
	 
}
/* 
 * SELECT * FROM `t_work` WHERE DATE_FORMAT(t_work.work_date,'%Y-%m')='2019-05'
 * OR DATE_FORMAT(t_work.work_date,'%Y-%m')='2019-06'
 * SELECT
    w.work_id,
    MONTHNAME(w.work_date) AS MONTHNAME,
    MONTH(w.work_date) AS MONTH,
    YEAR(w.work_date) AS YEAR,
    SUM(w.total_amt) AS work_amt,
    SUM(w.disc_amt) AS disc_amt,
    SUM(w.final_amt) AS final_amt
FROM
    t_work w
WHERE
    w.work_date BETWEEN '2019-05-01' AND '2019-08-31'
GROUP BY
    MONTH(w.work_date)
 */