package com.ats.tankwebapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.tankwebapi.model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
