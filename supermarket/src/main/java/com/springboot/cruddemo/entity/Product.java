package com.springboot.cruddemo.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="product")
public class Product {
	
	public Product() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;


	@Column(name="product_name",unique = true)
	private String productName;


	@Column(name="product_type")
	private String productType;
	
	@Column(name="product_price")
	private int productPrice;
	
	@Column(name="product_quantity")
	private int productQuantity;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productName='" + productName + '\'' +
				", productType='" + productType + '\'' +
				", productPrice=" + productPrice +
				", productQuantity=" + productQuantity +
				'}';
	}

	public Product(String productName, String productType, int productPrice, int productQuantity) {
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;

	}
}
