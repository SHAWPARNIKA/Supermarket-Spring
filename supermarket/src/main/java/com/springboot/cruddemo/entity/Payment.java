package com.springboot.cruddemo.entity;


import java.time.LocalDateTime;
import javax.persistence.*;
import com.springboot.cruddemo.Enum.PaymentMethod;
import com.springboot.cruddemo.Enum.PaymentStatus;


@Entity
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payment_id")
	private int payment_id;
	

	@Column(name="total_amount")
	private int total_amount;

	@Enumerated(EnumType.STRING)
	@Column(name="payment_mode")
	private PaymentMethod paymentMethod;

	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	@Column(name="date")
	private LocalDateTime date;


	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;


	public int getUser_id() {
		return user_id;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	private int user_id;


	public Payment(){

	}
	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}


	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", total_amount=" + total_amount
				+ ", payment_mode=" + paymentMethod + ", date=" + date + "]";
	}

	public Payment(int total_amount,PaymentMethod paymentMethod, LocalDateTime date) {
		this.total_amount = total_amount;
		this.paymentMethod = paymentMethod;
		this.date = date;
	}
	
	
}
