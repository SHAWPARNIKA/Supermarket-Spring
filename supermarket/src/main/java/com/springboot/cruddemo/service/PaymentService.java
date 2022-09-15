package com.springboot.cruddemo.service;

import com.springboot.cruddemo.entity.Payment;
import com.springboot.cruddemo.entity.Product;

import java.util.Map;

public interface PaymentService {

    public Payment makePayment(Map<String,String> paymentInput);

    public Payment findById(int theId);

}
