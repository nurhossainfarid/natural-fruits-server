package com.fruit.main.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	@Column(name="user_id")
	private Long userId;
	private Long productId;
	private int rating;
	private String comment;
	
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Feedback(Long id, String email, Long userId,Long productId, int rating, String comment) {
		super();
		this.id = id;
		this.email = email;
		this.userId = userId;
		this.productId = productId;
		this.rating = rating;
		this.comment = comment;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
}
