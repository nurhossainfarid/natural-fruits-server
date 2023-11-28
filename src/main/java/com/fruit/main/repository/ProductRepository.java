package com.fruit.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fruit.main.modal.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
