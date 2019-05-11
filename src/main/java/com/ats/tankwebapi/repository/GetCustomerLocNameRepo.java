package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.tankwebapi.model.GetCustomerLocName;

public interface GetCustomerLocNameRepo extends JpaRepository<GetCustomerLocName, Integer>{
	
	@Query(value = "select c.* ,l.location_name from m_customer as c, m_location as l "
			+ "  where c.area_id = l.location_id ", nativeQuery = true)		
	List<GetCustomerLocName> getCustomerListWithLocName();
}
