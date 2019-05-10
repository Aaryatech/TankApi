package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tankwebapi.model.Location;

public interface LocationRepo extends JpaRepository<Location, Integer>{

	@Transactional
	@Modifying
	@Query("update Location set del_status=0  WHERE location_id=:locationId")
	int deleteLocation(@Param("locationId") int locationId);

	List<Location> findByOrderByLocationIdDesc();

	Location findByLocationIdOrderByLocationIdDesc(int locationId);

	Location findByLocationIdAndDelStatusOrderByLocationIdDesc(int locationId, int i);

	List<Location> findByDelStatusOrderByLocationIdDesc(int i);

}
