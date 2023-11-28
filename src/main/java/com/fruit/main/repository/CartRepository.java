package com.fruit.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fruit.main.modal.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
