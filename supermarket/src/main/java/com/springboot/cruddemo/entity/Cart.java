package com.springboot.cruddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private int cartId;

	private int totalAmount;

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "cart")
	@JsonIgnore
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;

	public User getUser() {
		return user;
    }

    public void setUser(User user) {
		this.user = user;
	}

	public int getCart_id() {
		return cartId;
	}

	public void setCart_id(int cartId) {
		this.cartId = cartId;
	}


	@Override
	public String toString() {
		return "Cart [cart_id=" + cartId + "]";
	}

	public Cart() {

	}

}
