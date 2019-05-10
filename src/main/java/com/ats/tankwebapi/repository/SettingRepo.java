package com.ats.tankwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ats.tankwebapi.model.Setting;

public interface SettingRepo  extends JpaRepository<Setting, Integer>{

	@Transactional
	@Modifying
	@Query("update Setting set settings_value=:fromDate  WHERE settings_id=1")
	int UpdateDate(String fromDate);

	Setting findBySettingsId(int i);

}
