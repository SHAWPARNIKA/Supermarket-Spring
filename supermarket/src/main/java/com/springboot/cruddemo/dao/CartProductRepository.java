package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Cart;
import com.springboot.cruddemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.cruddemo.entity.Cart_Product;

import java.util.List;

public interface CartProductRepository extends JpaRepository<Cart_Product, Integer> {

    Cart_Product findByProductAndCart(Product product, Cart cart);

    //Cart_Product findByCart(Cart cart);

    List<Cart_Product> findByCart(Cart cart);

}
