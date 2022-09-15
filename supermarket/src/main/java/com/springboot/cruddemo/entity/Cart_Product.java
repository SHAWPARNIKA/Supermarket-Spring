package com.springboot.cruddemo.entity;

import javax.persistence.*;

@Entity
@Table(name="cart_product",uniqueConstraints = {@UniqueConstraint(columnNames = {"cart_id","product_id"})})
public class Cart_Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cp_id;

	@Column(name="quantity_purchased")
	private int quantity_purchased;

	//@Column(name = "netAmount")
	private int netAmount;

	@ManyToOne
	@JoinColumn(name = "Cart_id")
	public Cart cart;

	@ManyToOne
	@JoinColumn(name = "Product_id")
	public Product product;

	public Cart_Product() {

	}

	public int getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(int netAmount) {
		this.netAmount = netAmount;
	}

	public int getQuantity_purchased() {
		return quantity_purchased;
	}

	public void setQuantity_purchased(int quantity_purchased) {
		this.quantity_purchased = quantity_purchased;
	}

	@Override
	public String toString() {
		return "Cart_Product [quantity_purchased=" + quantity_purchased + "]";
	}

	public Cart_Product(Product product,Cart cart,int quantity_purchased) {
		this.cart=cart;
		this.product=product;
		this.quantity_purchased = quantity_purchased;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
