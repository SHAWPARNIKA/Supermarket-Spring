package com.springboot.cruddemo.service;

import com.springboot.cruddemo.Enum.PaymentMethod;
import com.springboot.cruddemo.Enum.PaymentStatus;
import com.springboot.cruddemo.dao.CartRepository;
import com.springboot.cruddemo.dao.PaymentRepository;
import com.springboot.cruddemo.entity.Cart;

import com.springboot.cruddemo.entity.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private UserService userService;




    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CartRepository cartRepository;


    @Autowired
    private ProductService productService;

    @Autowired
    private CartProductServiceImpl cartProductService;






    public Payment makePayment(Map<String,String> paymentInput){

        Payment payment=new Payment();
        Cart cart=cartRepository.findById(Integer.valueOf(paymentInput.get("cartId"))).get();
        payment.setCart(cart);
        payment.setUser_id(cart.getUser().getUser_id());
        payment.setTotal_amount(cart.getTotalAmount());
        payment.setDate(LocalDateTime.now());
        PaymentMethod paymentMethod=PaymentMethod.valueOf(paymentInput.get("paymentMethod"));
        if(paymentMethod==PaymentMethod.CARD){
            payment.setPaymentMethod(paymentMethod);
            payment.setPaymentStatus(PaymentStatus.SUCCESS);
        }else {
            payment.setPaymentMethod(paymentMethod);
            payment.setPaymentStatus(PaymentStatus.SUCCESS);
        }


            cartProductService.deleteCart(cart);
            cart.setTotalAmount(0);
            cartRepository.save(cart);


        return paymentRepository.save(payment);

    }

    @Transactional
    public Payment findById(int theId) {
        return paymentRepository.findById(theId).get();

    }
}
