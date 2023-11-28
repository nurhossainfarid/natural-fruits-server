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

import com.fruit.main.modal.OrderFruit;
import com.fruit.main.repository.OrderFruitRepository;

@RestController
@RequestMapping("/orderfruit")
public class OrderFruitController {
	@Autowired
	private OrderFruitRepository orderFruitRepo;
	
	// Get all order
	@GetMapping("/all")
	public List<OrderFruit> getAllOrder() {
		return orderFruitRepo.findAll();
	}
	
	// Add to order
	@PostMapping("/add")
	public OrderFruit addOrder(@RequestBody OrderFruit order) {
		return orderFruitRepo.save(order);
	}
	
	// Get order by id
	@GetMapping("/{oid}")
	public Optional<OrderFruit> getOrderById(@PathVariable("oid") Long id) {
		return orderFruitRepo.findById(id);
	}
	
	// Update order
	@PatchMapping("/update")
	public OrderFruit updateOrder(@RequestBody OrderFruit order) {
		return orderFruitRepo.save(order);
	}
	
	// Delete order
	@DeleteMapping("/delete/{oid}")
	public String deleteOrder(@PathVariable("oid") Long id) {
		try {
			orderFruitRepo.deleteById(id);
		} catch (Exception e) {
			return "Failed to delete order";
		}
		return "Successfully Delete order";
	}
}
