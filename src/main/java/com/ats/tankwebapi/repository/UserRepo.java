package com.ats.tankwebapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tankwebapi.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	
	@Transactional
	@Modifying
	@Query("update User set del_status=0  WHERE user_id=:userId")
	int deleteUser(@Param("userId") int userId);

	User findByUserIdOrderByUserIdDesc(int userId);

	List<User> findByOrderByUserIdDesc();

	User findByMobileNumberAndPassword(String userName, String pass);

	User findByUserIdAndDelStatusOrderByUserIdDesc(int userId, int i);

	List<User> findByDelStatusOrderByUserIdDesc(int i);

	User findByDelStatusAndMobileNumberAndPassword(int i, String userName, String pass);

	User findByUserIdAndDelStatusOrderByUserIdDesc(String string, int i);

	List<User> findByUserIdAndDelStatusOrderByUserIdDesc(String[] values, int i);

	List<User> findByDelStatus(int i);

	

}
