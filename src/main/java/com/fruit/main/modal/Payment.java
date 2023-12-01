package com.fruit.main.modal;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="payment")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="user_id")
	private Long userId;
	@Column(name="order_id")
	private Long orderId;
	private Boolean paid;
	@Column(name="total_price")
	private String totalPrice;
	private String details;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(Long id, Long userId, Long orderId, Boolean paid, String totalPrice, String details) {
		super();
		this.id = id;
		this.userId = userId;
		this.orderId = orderId;
		this.paid = paid;
		this.totalPrice = totalPrice;
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
