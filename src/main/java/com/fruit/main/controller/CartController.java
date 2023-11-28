package com.fruit.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fruit.main.modal.Cart;
import com.fruit.main.repository.CartRepository;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartRepository cartRepo;

	// Get All Cart
	@GetMapping("/all")
	public List<Cart> getAllCart() {
		return cartRepo.findAll();
	}

	// Add to cart
	@PostMapping("/add")
	public Cart addToCart(@RequestBody Cart cart) {
		return cartRepo.save(cart);
	}

	// Get cart by id
	@GetMapping("/{cid}")
	public Optional<Cart> getCart(@PathVariable("cid") Long id) {
		return cartRepo.findById(id);
	}
	
	// 	Update cart
	@PatchMapping("/update")
	public Cart updateCart(@RequestBody Cart cart) {
		return cartRepo.save(cart);
	}
	
	// Delete cart
	@DeleteMapping("/delete/{cid}")
	public String deleteCart(@PathVariable("cid") Long id) {
		try {
			cartRepo.deleteById(id);
		} catch (Exception e) {
			return "Failed to delete cart";
		}
		
		return "Successfully delete cart";
	}
}
