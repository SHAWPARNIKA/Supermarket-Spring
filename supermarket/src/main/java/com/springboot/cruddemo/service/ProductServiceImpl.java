package com.springboot.cruddemo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.cruddemo.dao.ProductRepository;
import com.springboot.cruddemo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductServiceImpl(ProductRepository theProductRepository) {
		productRepository = theProductRepository;
	}

	@Override
	@Transactional
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Transactional
	public void deleteById(int theId) {
		productRepository.deleteById(theId);
	}


	public Product addProduct(Map<String,String> productInput){
		Product product=new Product();
		product.setProductName(productInput.get("product_name"));
		product.setProductPrice(Integer.parseInt(productInput.get("product_price")));
		product.setProductQuantity(Integer.parseInt(productInput.get("product_quantity")));
		product.setProductType(productInput.get("product_type"));
		return productRepository.save(product);
	}
	@Override
	@Transactional
	public Product findById(int theId) {
		return productRepository.findById(theId).get();

	}

}
