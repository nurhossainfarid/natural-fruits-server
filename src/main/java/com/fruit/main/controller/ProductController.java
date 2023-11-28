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

import com.fruit.main.modal.Product;
import com.fruit.main.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepo;
	
	//Get All Product	
	@GetMapping("/all")
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}
	
	//Create A Product	
	@PostMapping("/create")
	public Product addProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	//Get One Product by Id
	@GetMapping("/{pid}")
	public Optional<Product> getProduct(@PathVariable("pid") Long id){
		return productRepo.findById(id);
	}
	
	//	Update Product
	@PatchMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}
	
	//	Delete Product
	@DeleteMapping("/delete/{pid}") 
	public String deleteProduct(@PathVariable("pid") Long id) {
		try {
			productRepo.deleteById(id);
		} catch(Exception ex) {
			return "Failed";
		}
		
		return "Delete Successfully";
	}
}
