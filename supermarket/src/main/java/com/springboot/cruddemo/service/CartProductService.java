package com.springboot.cruddemo.service;

import com.springboot.cruddemo.entity.Cart_Product;
import java.util.Map;

public interface CartProductService {

	public Cart_Product addToCart(Map<String,String> addCartInput);

	public void removeFromCart(Map<String,String> removeCartInput);
}
