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

import com.fruit.main.modal.Payment;
import com.fruit.main.repository.PaymentRepository;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentRepository paymentRepo;
	
	// Get all payment
	@GetMapping("/all")
	public List<Payment> getAllPayment() {
		return paymentRepo.findAll();
	}
	
	// Payment
	@PostMapping("/pay")
	public Payment addPayment(@RequestBody Payment payment) {
		return paymentRepo.save(payment);
	}
	
	// Get Payment by id
	@GetMapping("/{pid}")
	public Optional<Payment> getPaymentById(@PathVariable("pid") Long id) {
		return paymentRepo.findById(id);
	}
	
	// Update payment
	@PatchMapping("/update")
	public Payment updatePayment(@RequestBody Payment payment) {
		return paymentRepo.save(payment);
	}
	// Delete payment by id
	@DeleteMapping("/delete/{pid}")
	public String deletePayment(@PathVariable("pid") Long id) {
		try {
			paymentRepo.deleteById(id);
		} catch (Exception e) {
			return "Failed to delete payment";
		}
		
		return "Successfully delete payment";
	}
}
