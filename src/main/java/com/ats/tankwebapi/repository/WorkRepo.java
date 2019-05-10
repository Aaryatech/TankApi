package com.ats.tankwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tankwebapi.model.Work;

public interface WorkRepo extends JpaRepository<Work, Integer>{

}
