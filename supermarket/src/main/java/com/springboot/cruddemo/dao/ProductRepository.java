package com.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.cruddemo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Override
	public List<Product> findAll();

}
