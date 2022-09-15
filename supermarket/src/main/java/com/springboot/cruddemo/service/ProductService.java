package com.springboot.cruddemo.service;

import java.util.List;
import java.util.Map;

import com.springboot.cruddemo.entity.Product;
import org.springframework.stereotype.Service;

public interface ProductService {

	public List<Product> findAll();
	public void deleteById(int theId);
	public Product findById(int theId);

	public Product addProduct(Map<String ,String> productInput);
}
