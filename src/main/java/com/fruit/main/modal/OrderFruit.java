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
@Table(name="order_fruit")
public class OrderFruit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	@Column(name="user_id")
	private Long userId;
	private String product;
	private String quantity;
	private String price;
	private String address;
	@Column(name="payment_status")
	private String paymentStatus;
	@Column(name="delivery_status")
	private String deliveryStatus;
	public OrderFruit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderFruit(Long id, String email, Long userId, String product, String quantity, String price, String address,
			String paymentStatus, String deliveryStatus) {
		super();
		this.id = id;
		this.email = email;
		this.userId = userId;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.address = address;
		this.paymentStatus = paymentStatus;
		this.deliveryStatus = deliveryStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
}
