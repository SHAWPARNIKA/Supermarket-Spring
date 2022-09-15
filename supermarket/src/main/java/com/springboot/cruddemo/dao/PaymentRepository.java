package com.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.cruddemo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
