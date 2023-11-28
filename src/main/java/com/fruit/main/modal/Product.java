package com.fruit.main.modal;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="fruits")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private String category;
	private String imageUrl;
	private int quantity;
	private String price;
	private String stock;
	private int discountPrice;
	private int discountPersent;
	
//	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//	@JoinTable(name = "order_confirmation", joinColumns = @JoinColumn(name = "pid"), inverseJoinColumns = @JoinColumn(name = "oid"))
//	private List<Order> orders;
//	

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(Long id, String name, String description, String category, String imageUrl, int quantity,
			String price, String stock, int discountPrice, int discountPersent) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.price = price;
		this.stock = stock;
		this.discountPrice = discountPrice;
		this.discountPersent = discountPersent;
	}
	
	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public int getDiscountPersent() {
		return discountPersent;
	}

	public void setDiscountPersent(int discountPersent) {
		this.discountPersent = discountPersent;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
}
