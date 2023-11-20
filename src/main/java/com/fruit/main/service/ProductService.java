package com.fruit.main.service;

import org.springframework.data.domain.Page;

import com.fruit.main.exception.ProductException;
import com.fruit.main.modal.Product;
import com.fruit.main.request.CreateProductRequest;

public interface ProductService {
	
	public Product createProduct(CreateProductRequest req);
	
	public String deleteProduct(Long productId) throws ProductException;
	
	public Product updateProduct(Long productId, Product req) throws ProductException;
	
	public Product findProductById(Long productId) throws ProductException;
	
	public Page<Product> getAllProduct(String category, Integer minPrice, Integer maxPrice, Integer discount, String sort, Boolean stock, Integer pageNumber, Integer pageSize);
	
}
