package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Cart_Product;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.cruddemo.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
