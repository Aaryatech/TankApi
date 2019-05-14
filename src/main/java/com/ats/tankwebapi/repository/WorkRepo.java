package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.ats.tankwebapi.model.Work;

public interface WorkRepo extends JpaRepository<Work, Integer>{

	List<Work> findByStatusAndDelStatus(int status, int i);

	@Transactional
	@Modifying
	@Query("update Work set del_status=0  WHERE work_id=:workId")
	int deleteAssignedWork(@Param("workId") int workId);


}
