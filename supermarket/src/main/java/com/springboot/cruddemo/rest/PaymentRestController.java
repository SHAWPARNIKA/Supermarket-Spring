package com.springboot.cruddemo.rest;

import com.springboot.cruddemo.entity.Payment;
import com.springboot.cruddemo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/makePayment")
    public ResponseEntity<Payment> makePayment(@RequestBody Map<String,String> paymentInput){
        return new ResponseEntity<>(paymentService.makePayment(paymentInput), HttpStatus.CREATED);
    }

    @GetMapping("/getById/{paymentId}")
    public ResponseEntity<Payment> getPaymentDetails(@PathVariable int paymentId) {
        return ResponseEntity.ok(paymentService.findById(paymentId));
    }

}
