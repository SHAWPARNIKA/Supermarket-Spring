package com.springboot.cruddemo.entity;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;

	@Size(min = 3,message = "User name must contain at least 3 character")
	@Column(name="user_name")
	private String user_name;

	@Digits(integer = 10,fraction = 0,message = "Only 10 digits allowed")
	@Column(name="phone_number")
	private long phone_number;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private Cart cart;

    public User() {

    }

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "User{" +
				"user_id=" + user_id +
				", user_name='" + user_name + '\'' +
				", phone_number=" + phone_number +
				", cart=" + cart +
				'}';
	}

	public User(int user_id, String user_name, long phone_number, Cart cart) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.phone_number = phone_number;
		this.cart = cart;
	}
}
