package com.fruit.main.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fruit.main.exception.ProductException;
import com.fruit.main.modal.Product;
import com.fruit.main.repository.ProductRepository;
import com.fruit.main.request.CreateProductRequest;

@Service
public class ProductServiceImplementation implements ProductService {
	
	private ProductRepository productRepository;
	private UserService userService;
	
	public ProductServiceImplementation() {
		// TODO Auto-generated constructor stub
	}

	public ProductServiceImplementation(ProductRepository productRepository, UserService userService) {
		super();
		this.productRepository = productRepository;
		this.userService = userService;
	}

	@Override
	public Product createProduct(CreateProductRequest req) {
		Product product = new Product();
		product.setName(req.getName());
		product.setDescription(req.getDescription());
		product.setCategory(req.getCategory());
		product.setImageUrl(req.getImageUrl());
		product.setQuantity(req.getQuantity());
		product.setPrice(req.getPrice());
		product.setStock(req.getStock());
		product.setDiscountPrice(req.getDiscountPrice());
		product.setDiscountPersent(req.getDiscountPersent());
		
		Product savedProduct = productRepository.save(product);
		return savedProduct;
	}

	@Override
	public String deleteProduct(Long productId) throws ProductException {
		Product product = findProductById(productId);
		productRepository.delete(product);
		return "Product deleted Successfully";
	}

	@Override
	public Product updateProduct(Long productId, Product req) throws ProductException {
		
		Product product = findProductById(productId);
		
		if (req.getQuantity()!=0) {
			product.setQuantity(req.getQuantity());
		}
		
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(Long productId) throws ProductException {
		Optional<Product> opt = productRepository.findById(productId);
		
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new ProductException("Product not found with id -"+productId);
	}

//	@Override
//	public Page<Product> getAllProduct(String category, Integer minPrice, Integer maxPrice, Integer discount,
//			String sort, Boolean stock, Integer pageNumber, Integer pageSize) {
//		Pageable pageable = (Pageable) PageRequest.of(pageNumber, pageSize);
//		
//		List<Product> products = productRepository.filterProducts(category, minPrice, maxPrice, discount, sort);
//		
//		if(stock !=null) {
//			if(stock.equals("in_stock")) {
//				products = products.stream().filter(p -> p.getQuantity()>0).collect(Collectors.toList());
//			} else if(stock.equals("out_of_stock")) {
//				products = products.stream().filter(p -> p.getQuantity()<1).collect(Collectors.toList());
//			}
//		}
//		
//		int startIndex = (int) pageable.getOffset();
//		int endIndex = Math.min(startIndex, pagebl.getPageSize(), product.size());
//		return null;
//	}


}
